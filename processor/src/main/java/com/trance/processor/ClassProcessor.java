package com.trance.processor;

import com.google.auto.service.AutoService;
import com.trance.annotations.BindView;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

/**
 * 在Java 7以后，也可以使用注解来代替getSupportedAnnotationTypes方法和getSupportedSourceVersion方法
 * 但是考虑到 Android 兼容性的问题，这里不建议采用这种注解的方式
 * //@SupportedAnnotationTypes("com.trance.annotations.BindView")
 * //@SupportedSourceVersion(SourceVersion.RELEASE_8)
 */
@AutoService(Processor.class)
public class ClassProcessor extends AbstractProcessor {
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Messager messager = processingEnv.getMessager();
        for (Element element : roundEnvironment.getElementsAnnotatedWith(BindView.class))
            if (element.getKind() == ElementKind.FIELD)
                messager.printMessage(Diagnostic.Kind.NOTE, "printMessage:" + element.toString());
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(BindView.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
