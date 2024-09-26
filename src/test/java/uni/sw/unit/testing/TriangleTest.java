package uni.sw.unit.testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {

    @BeforeAll
    public static void setup(){
        System.out.println("BeforeAll demo: setup test execution");
    }


    @AfterAll
    public static void tearDown(){
        System.out.println("AfterAll demo: tear down test execution");
    }


    @BeforeEach
    public void initTest(){
        System.out.println("BeforeEach demo: init test case");
    }


    @AfterEach
    public void tearDownTest(){
        System.out.println("AfterEach demo: tear down case");
    }


    @Test
    public void testGenericTriangle(){
        System.out.println("Testing generic triangle");

        Triangle triangle = new Triangle(3, 4, 6);

        assertTrue(triangle instanceof Triangle);
        assertFalse(triangle.isIsosceles());
        assertFalse(triangle.isEquilateral());
        assertFalse(triangle.isRightAngeled());
    }


    @Test
    public void testIsoscelesTriangle(){
        System.out.println("Testing isosceles triangle");

        Triangle triangle = new Triangle(3, 3, 5);

        assertTrue(triangle instanceof Triangle);
        assertTrue(triangle.isIsosceles());

        triangle = new Triangle(3, 5, 3);
        assertTrue(triangle.isIsosceles());

        triangle = new Triangle(5, 3, 3);
        assertTrue(triangle.isIsosceles());
    }


    @Test
    public void testEquilateralTriangle(){
        Triangle triangle = new Triangle(3, 3, 3);

        assertTrue(triangle instanceof Triangle);
        assertTrue(triangle.isIsosceles());
        assertTrue(triangle.isEquilateral());
    }


    @Test
    public void testRightAngeledTriangle(){
        Triangle triangle = new Triangle(3, 4, 5);

        assertTrue(triangle instanceof Triangle);
        assertTrue(triangle.isRightAngeled());

        triangle = new Triangle(4, 5, 3);
        assertTrue(triangle.isRightAngeled());

        triangle = new Triangle(5, 4, 3);
        assertTrue(triangle.isRightAngeled());
    }


    @Test
    public void testPerimeter(){
        Triangle triangle = new Triangle(100, 251, 178);

        assertEquals(529, triangle.getPerimeter(), "Calculated perimeter doesn't match expected value");
    }


    @Test
    public void testArea(){
        Triangle triangle = new Triangle(6, 8, 10);

        assertEquals(24, triangle.getArea(), "Calculated area doesn't match expected value");
    }


    @Test
    public void testNotConstructableTriangle(){
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            new Triangle(6, 8, 30);
        });
        assertTrue(exception.getMessage().contains("The triangle cannot be constructed from the the numbers"));

        assertThrows(ArithmeticException.class, () -> {
            new Triangle(6, 30, 6);
        });
        assertThrows(ArithmeticException.class, () -> {
            new Triangle(60, 30, 26);
        });
    }
}