import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.NewTask;
import pojo.NewTaskBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewTaskTest {
    private static final String basePath = "https://api.todoist.com/rest/v1";
    private static final String bearerToken = "595b4859795a2cd548341d85832459ed70a85e1e";
    private final String postTask = "/tasks";
    private String defaultContent = "default content for tasks ";

    public RequestSpecification REQUEST;

    @BeforeEach
    public void setup() {
        baseURI = basePath;
        String date = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(new Date());
        defaultContent = defaultContent + date;
        REQUEST = RestAssured.given().header("Authorization", "Bearer " + bearerToken).contentType(ContentType.JSON + "\r\n");
    }

    @Test
    public void createTaskOnlyContent() {
        NewTask task = new NewTask();
        task.setContent(defaultContent);
        Gson gson = new Gson();
        String jsonObject = gson.toJson(task);

        REQUEST.given()
                .body(jsonObject)
                .when()
                .post(postTask)
                .then().statusCode(SC_OK);
    }

    @Test
    void createTaskWithAllFields() {
        NewTaskBuilder newTaskBuilder = new NewTaskBuilder.Builder(defaultContent)
                .dueDate("dueDate")
                .dueDateTime("dueDateTime")
                .dueLang("dueLang")
                .dueString("dueString")
                .labelsIds(new Integer[]{1, 2, 3})
                .order(1)
                .parent(0)
                .priority(1)
                .projectId(1)
                .sectionId(1)
                .build();
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(newTaskBuilder);
        REQUEST.given()
                .body(json)
                .when()
                .post(postTask)
                .peek()
                .then().statusCode(SC_OK).log().all().extract().response();
    }

    @Test
    void createTaskWithEmptyContent() {
        NewTaskBuilder newTaskBuilder = new NewTaskBuilder.Builder("")
                .build();
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(newTaskBuilder);

        String response = REQUEST.given()
                .body(json)
                .when()
                .post(postTask)
                .then().statusCode(SC_BAD_REQUEST).log().all().extract().asString();
        assertTrue(response.contains("Empty content"));
    }

    @Test
    void createTaskWithoutContentField() {
        String json = ("{\"project_id\": 1}");

        String response = REQUEST.given()
                .body(json)
                .when()
                .post(postTask)
                .then().statusCode(SC_BAD_REQUEST).log().all().extract().asString();
        assertTrue(response.contains("Empty content"));
    }

    @Test
    void createTaskWithNonexistentValue() {
        NewTaskBuilder newTaskBuilder = new NewTaskBuilder.Builder(defaultContent)
                .parent(10)
                .build();
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(newTaskBuilder);
        REQUEST.given()
                .body(json)
                .when()
                .post(postTask)
                .peek()
                .then().statusCode(SC_INTERNAL_SERVER_ERROR).log().all().extract().response();
    }


}
