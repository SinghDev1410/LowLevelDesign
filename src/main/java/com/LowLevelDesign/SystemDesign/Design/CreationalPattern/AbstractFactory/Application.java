package com.LowLevelDesign.SystemDesign.Design.CreationalPattern.AbstractFactory;

interface Button{ void paint(); }
interface CheckBox{ void render(); }

class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Rendering a Windows Button.");
    }
}

class WindowCheckbox implements CheckBox{
    @Override
    public void render() {
        System.out.println("Rendering a Windows Checkbox.");
    }
}

class MacButton implements Button{
    @Override
    public void paint() {
        System.out.println("Rendering a MacOS Button.");
    }
}

class MacCheckbox implements CheckBox{
    @Override
    public void render() {
        System.out.println("Rendering a MacOS Checkbox.");
    }
}

interface GUIFactory{
    Button createButton();
    CheckBox createCheckBox();
}

class WindowFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowCheckbox();
    }
}

class MacOsFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckbox();
    }
}

public class Application {
    Button button;
    CheckBox checkBox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void renderUI(){
        button.paint();
        checkBox.render();
    }
}

class Main{
    public static void main(String[] args) {
        GUIFactory factory;

        String osName = String.format("mac").toLowerCase();
        if(osName.contains("mac")) factory = new MacOsFactory();
        else factory = new WindowFactory();
        
        Application app = new Application(factory);
        app.renderUI();
    }
}