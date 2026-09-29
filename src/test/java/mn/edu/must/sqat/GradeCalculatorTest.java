package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GradeCalculatorTest {

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой (хязгаарын тохиолдол)")
    void ninetyIsExactlyA() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(90.0);
        assertEquals("A", grade);
    }

    @ParameterizedTest
    @DisplayName("Үсгэн дүнгийн хязгаар болон ердийн утгуудыг шалгах")
    @CsvSource({
        "95, A",
        "90, A",
        "89.99, B",
        "80, B",
        "79.99, C",
        "70, C",
        "69.99, D",
        "60, D",
        "59.99, F",
        "0, F"
    })
    void letterGradeBoundaries(double score, String expected) {
        GradeCalculator calc = new GradeCalculator();
        assertEquals(expected, calc.letterGrade(score));
    }

    @ParameterizedTest
    @DisplayName("Буруу оноо өгөхөд IllegalArgumentException шидэхийг шалгах")
    @CsvSource({
        "-1.0",
        "100.01",
        "-50.0",
        "150.0"
    })
    void invalidScoreThrowsException(double invalidScore) {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(invalidScore));
    }

    @Test
    @DisplayName("Нийлбэр оноог хэвийн утгаар зөв тооцоолох")
    void totalScoreValidCalculation() {
        GradeCalculator calc = new GradeCalculator();
        double total = calc.totalScore(10.0, 40.0, 10.0, 10.0, 30.0);
        assertEquals(100.0, total);
    }

    @Test
    @DisplayName("Ирцийн оноо хязгаараас хэтэрвэл алдаа шидэх")
    void totalScoreInvalidAttendance() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.totalScore(-1.0, 40.0, 10.0, 10.0, 30.0));
        assertThrows(IllegalArgumentException.class, () -> calc.totalScore(11.0, 40.0, 10.0, 10.0, 30.0));
    }

    @Test
    @DisplayName("Лабораторийн оноо хязгаараас хэтэрвэл алдаа шидэх")
    void totalScoreInvalidLab() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.totalScore(10.0, -0.1, 10.0, 10.0, 30.0));
        assertThrows(IllegalArgumentException.class, () -> calc.totalScore(10.0, 40.1, 10.0, 10.0, 30.0));
    }

    @Test
    @DisplayName("Шалгалтын оноо хязгаараас хэтэрвэл алдаа шидэх")
    void totalScoreInvalidExam() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.totalScore(10.0, 40.0, 10.0, 10.0, -1.0));
        assertThrows(IllegalArgumentException.class, () -> calc.totalScore(10.0, 40.0, 10.0, 10.0, 30.1));
    }

    @ParameterizedTest
    @DisplayName("Нийлбэр онооны параметржүүлсэн хязгаар шалгах")
    @CsvSource({
        "5.0, 20.0, 5.0, 5.0, 15.0, 50.0",
        "0.0, 0.0, 0.0, 0.0, 0.0, 0.0"
    })
    void totalScoreParameterizedValid(double att, double lab, double q1, double q2, double exam, double expected) {
        GradeCalculator calc = new GradeCalculator();
        assertEquals(expected, calc.totalScore(att, lab, q1, q2, exam));
    }
}