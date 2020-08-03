package org.quantcero.json;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.quantcero.inventorybackend.json.Converter;
import org.quantcero.inventorybackend.json.jsonobjects.Command;

public class ConverterTest {

    private Converter converter;

    @Before
    public void assemble() {
        converter = Converter.getConverter();
    }

    @Test
    public void testSingleton() {
        Assert.assertSame(converter, Converter.getConverter());
    }

    @Test
    public void parseJson() {
        String testJson = "{'action': 'helloworld', 'objects': {'a': 1, 'b': 42} }";
        Command command = converter.parseRawCommand(testJson);
        Assert.assertEquals("helloworld" , command.action);
        Assert.assertNull(command.token);
        Assert.assertEquals(command.objects.get("a"), "1");
        Assert.assertEquals(command.objects.get("b"), "42");
    }

    @After
    public void disassemble() {
        converter = null;
    }

}
