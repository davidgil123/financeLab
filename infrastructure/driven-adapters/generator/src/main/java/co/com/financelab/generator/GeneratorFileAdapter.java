package co.com.financelab.generator;

import co.com.financelab.model.download.gateways.DownloadGateway;
import co.com.financelab.model.download.gateways.UserWithAllData;
import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.income.Income;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
@Component
public class GeneratorFileAdapter implements DownloadGateway {
    @Override
    public Mono<byte[]> generateFile(UserWithAllData userWithAllData) {

        try (var workbook= new XSSFWorkbook()){ //Aqui creamos el libro con extension XLS
            var sheet= workbook.createSheet("Estado de cuenta"); //Creamos la hoja del libro
            var cell= sheet.createRow(0); //Creamos la fila donde van los titulos de cada columna
            //Nos creamos las columnas y les asignamos el valor o titulo a los encabezados.
            var fecha= cell.createCell(0); //
            fecha.setCellValue("Fecha");
            var tipoRegistro= cell.createCell(1);
            tipoRegistro.setCellValue("Tipo de Registro");
            var categoria= cell.createCell(2);
            categoria.setCellValue("Categoria");
            var subcategoria= cell.createCell(3);
            subcategoria.setCellValue("Subcategoria");
            var valor= cell.createCell(4);
            valor.setCellValue("Valor");
            var blanco= cell.createCell(5);
            blanco.setCellValue("");
            var usuario= cell.createCell(6);
            usuario.setCellValue("Usuario");
            var userId= cell.createCell(7);
            userId.setCellValue(userWithAllData.getUserId());
            var counter=1;
            var totalIncomes=0;
            var totalExpenses=0;

            //Aquí le asignamos el valor a las filas dinamicamente.
            for (Income income: userWithAllData.getIncomeList()) {

                var cellData= sheet.createRow(counter);
                var fecha2= cellData.createCell(0); //
                fecha2.setCellValue(income.getDate());
                var tipoRegistro2= cellData.createCell(1);
                tipoRegistro2.setCellValue("Ingreso");
                var categoria2= cellData.createCell(2);
                categoria2.setCellValue(income.getCategory());
                var subcategoria2= cellData.createCell(3);
                subcategoria2.setCellValue(income.getSubCategory());
                var valor2= cellData.createCell(4);
                valor2.setCellValue(Integer.parseInt(income.getAmount()));
                counter++;
                totalIncomes+= Integer.parseInt(income.getAmount());
            }

            for (Expense expense: userWithAllData.getExpenseList()) {

                var cellData= sheet.createRow(counter);
                var fecha2= cellData.createCell(0); //
                fecha2.setCellValue(expense.getDate());
                var tipoRegistro2= cellData.createCell(1);
                tipoRegistro2.setCellValue("Gasto");
                var categoria2= cellData.createCell(2);
                categoria2.setCellValue(expense.getCategory());
                var subcategoria2= cellData.createCell(3);
                subcategoria2.setCellValue(expense.getSubCategory());
                var valor2= cellData.createCell(4);
                valor2.setCellValue(Integer.parseInt(expense.getAmount()));
                counter++;
                totalExpenses+= Integer.parseInt(expense.getAmount());
            }
            var cellData= sheet.getRow(2);
            var totalIncomesData= cellData.createCell(6);
            totalIncomesData.setCellValue("Total Ingresos");
            var total= cellData.createCell(7);
            total.setCellValue(totalIncomes);
            var cellData3= sheet.getRow(3);
            var totalExpensesData= cellData3.createCell(6);
            totalExpensesData.setCellValue("Total Gastos");
            var total2= cellData3.createCell(7);
            total2.setCellValue(totalExpenses);
            var cellData4= sheet.getRow(4);
            var balance= cellData4.createCell(6);
            balance.setCellValue("Balance");
            var total3= cellData4.createCell(7);
            total3.setCellValue(totalIncomes-totalExpenses);

            var outputStream=new ByteArrayOutputStream();
            workbook.write(outputStream);
            return Mono.just(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
