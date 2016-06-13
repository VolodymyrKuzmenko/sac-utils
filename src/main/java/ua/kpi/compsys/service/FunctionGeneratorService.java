package ua.kpi.compsys.service;

import com.kpi.kuzmenko.generator.core.EnumerationGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class FunctionGeneratorService implements InitializingBean {

    @Value("${generator.argumenta.size}")
    private int size;

    private Iterator<int[]> iterator;

    private EnumerationGenerator generator;

    @Override
    public void afterPropertiesSet() throws Exception {
        generator = new EnumerationGenerator(size);
        generator.generate();
        iterator = generator.getEnumList().iterator();
    }

    public int[] getNextSacFunction() {
        return iterator.next();
    }
}
