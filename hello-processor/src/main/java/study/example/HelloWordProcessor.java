package study.example;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("study.example.HelloWorld")
@SupportedOptions("debug")
@AutoService(Processor.class)
public class HelloWordProcessor extends AbstractProcessor {
    private static final String HELLO_TEMPLATE =
            "package %1$s;\n\npublic class %2$sHello {\n  public static void sayHello() {\n    System.out.println(\"Hello %3$s\");\n  }\n}\n";

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (Element element : roundEnvironment.getElementsAnnotatedWith(HelloWorld.class)) {
            TypeElement typeElem = (TypeElement) element;
            String typeName = typeElem.getQualifiedName().toString();
            Filer filer = processingEnv.getFiler();
            try (Writer sw = filer.createSourceFile(typeName + "Hello").openWriter()) {
                log("Generating " + typeName + "Hello source code");
                int lastIndex = typeName.lastIndexOf('.');
                sw.write(String.format(HELLO_TEMPLATE, typeName.substring(0, lastIndex), typeName.substring(lastIndex + 1), typeName));
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.getMessage());
            }
        }
        return true;
    }

    private void log(String msg) {
        if (processingEnv.getOptions().containsKey("debug")) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, msg);
        }
    }
}
