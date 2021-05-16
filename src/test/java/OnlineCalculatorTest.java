import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OnlineCalculatorTest {

    private static OnlineCalculator onCalc;

    @BeforeAll
    public static void setUp(){
        onCalc = new OnlineCalculator();
    }

    @AfterAll
    public static void close(){
        onCalc.close();
    }

    @DisplayName("Addition")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "5, 5, 10",
            "2, 2, 4,",
             "3, 3, 6"
    })
    void add(int a, int b, int expectedResult) {
        assertEquals(expectedResult, onCalc.add(a, b), 
                () -> a +" + "+ b + "should equal " + expectedResult);
    }


    @DisplayName("Subtraction")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "5, 2, 3",
            "9, 2, 7,",
            "3, 2, 1"
    })
    void sub(int a, int b, int expectedResult) {
        assertEquals(expectedResult, onCalc.sub(a, b),
                () -> a +" + "+ b + "should equal " + expectedResult);
    }
}