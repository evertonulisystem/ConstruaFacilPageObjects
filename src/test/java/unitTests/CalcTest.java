package unitTests;

import devcalc.Calc;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class CalcTest {

    @Test
    public void testarSomarDoisNumeros() {
        //Prepara - Given
        int num1 =5;
        int num2=7;
        int resultadoEsperado=129;

        //Executar - When
        int resultadoAtual = Calc.somarDoisNumeros(num1,num2);

        //Validar - Then
        assertEquals(resultadoEsperado,resultadoAtual);

    }
}
