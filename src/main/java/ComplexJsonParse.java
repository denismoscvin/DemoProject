import files.payload;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

public class ComplexJsonParse {
    public static void main(String[] args) {
        JsonPath jsonPath = new JsonPath(payload.CoursePrice());

        //Print no of courses returned by API
        int count = jsonPath.getInt("courses.size()");
        System.out.println(count);

        //Print purchased amount
        int purchasedAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(purchasedAmount);

        //Print title of the first course
        String nameOfFirstCourse = jsonPath.getString("courses[0].title");
        System.out.println(nameOfFirstCourse);

        //Print all courses title and respective price
        for (int i = 0; i < count; i++) {
            String courseTitles = jsonPath.getString("courses[" + i + "].title");
            int coursePrice = jsonPath.getInt("courses[" + i + "].price");
            System.out.println(courseTitles + ": " + coursePrice);
        }

        //Print no of copies sold by RPA courses
        for (int i = 0; i < count; i++) {
            String courseTitles = jsonPath.getString("courses[" + i + "].title");
            if (courseTitles.equalsIgnoreCase("RPA")) {
                int copies = jsonPath.getInt("courses[" + i + "].copies");
                System.out.println("no of copies sold by RPA courses: " + copies);
                break;
            }

        }

        //Print if Sum of all courses matches with Purchased Amount
        int sum = 0;
        for (int i = 0; i < count; i++) {
            int coursePrice = jsonPath.getInt("courses[" + i + "].price");
            int courseCount = jsonPath.getInt("courses[" + i + "].copies");
            sum = sum + (coursePrice * courseCount);
        }
        System.out.println(sum);

        Assert.assertEquals(sum, purchasedAmount);
//        if (sum == purchasedAmount) {
//            System.out.println("The sum of courses and purchased Amount is matched");
//        } else {
//            System.out.println("The sum of courses and purchased Amount is matched");
//        }
    }
}
