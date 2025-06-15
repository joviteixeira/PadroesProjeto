
interface Button {
    void render();
}

interface Icon {
    void show();
}

interface UIThemeFactory {
    Button createButton();
    Icon createIcon();
}

class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando botão com estilo Light.");
    }
}

class LightIcon implements Icon {
    @Override
    public void show() {
        System.out.println("Mostrando ícone com estilo Light.");
    }
}

class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando botão com estilo Dark.");
    }
}

class DarkIcon implements Icon {
    @Override
    public void show() {
        System.out.println("Mostrando ícone com estilo Dark.");
    }
}

class LightThemeFactory implements UIThemeFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Icon createIcon() {
        return new LightIcon();
    }
}

class DarkThemeFactory implements UIThemeFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Icon createIcon() {
        return new DarkIcon();
    }
}

class Application {
    private Button button;
    private Icon icon;

    public Application(UIThemeFactory factory) {
        this.button = factory.createButton();
        this.icon = factory.createIcon();
    }

    public void displayUI() {
        button.render();
        icon.show();
    }
}

public class CenarioComplexo {
    public static void main(String[] args) {
        System.out.println("--- Demonstração do Abstract Factory ---");

        System.out.println("\nCriando UI com o tema Light:");
        UIThemeFactory lightFactory = new LightThemeFactory();
        Application lightApp = new Application(lightFactory);
        lightApp.displayUI();

        System.out.println("\nCriando UI com o tema Dark:");
        UIThemeFactory darkFactory = new DarkThemeFactory();
        Application darkApp = new Application(darkFactory);
        darkApp.displayUI();
    }
}