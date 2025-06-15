interface Report {
    void generate();
}

class PdfReport implements Report {
    @Override
    public void generate() {
        System.out.println("--- Gerando Relatório PDF ---");
        System.out.println("Cabeçalho do PDF: Relatório Mensal de Vendas");
        System.out.println("Corpo: [Dados do relatório em formato binário para PDF]");
        System.out.println("Rodapé do PDF: © 2025 Rede de Restaurantes");
        System.out.println("Relatório PDF gerado com sucesso.\n");
    }
}

class HtmlReport implements Report {
    @Override
    public void generate() {
        System.out.println("--- Gerando Relatório HTML ---");
        System.out.println("<html>");
        System.out.println("  <head><title>Relatório Mensal de Vendas</title></head>");
        System.out.println("  <body><h1>Dados do Relatório</h1></body>");
        System.out.println("</html>");
        System.out.println("Relatório HTML gerado com sucesso.\n");
    }
}

class JsonReport implements Report {
    @Override
    public void generate() {
        System.out.println("--- Gerando Relatório JSON ---");
        System.out.println("{");
        System.out.println("  \"titulo\": \"Relatório Mensal de Vendas\",");
        System.out.println("  \"dados\": { \"vendas\": 15000, \"pedidos\": 780 }");
        System.out.println("}");
        System.out.println("Relatório JSON gerado com sucesso.\n");
    }
}

interface ReportFactory {
    Report createReport();
}


class PdfReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new PdfReport();
    }
}

class HtmlReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new HtmlReport();
    }
}

class JsonReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new JsonReport();
    }
}


public class CenarioSimples {
    public static void main(String[] args) {
        System.out.println("### Demonstração do Padrão Factory Method ###\n");


        ReportFactory pdfFactory = new PdfReportFactory();
        Report pdfReport = pdfFactory.createReport();
        pdfReport.generate();

        ReportFactory htmlFactory = new HtmlReportFactory();
        Report htmlReport = htmlFactory.createReport();
        htmlReport.generate();

        ReportFactory jsonFactory = new JsonReportFactory();
        Report jsonReport = jsonFactory.createReport();
        jsonReport.generate();
    }
}
