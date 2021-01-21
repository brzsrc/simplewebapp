package ic.doc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutAsimov() throws Exception {
        assertThat(queryProcessor.process("Asimov"), containsString("science fiction"));
    }

    @Test
    public void knowsAboutJamesBaldwin() throws Exception {
    	assertThat(queryProcessor.process("James Baldwin"), containsString("activist"));
    }

    @Test
    public void knowsAboutEmilyBronte() throws Exception {
    	assertThat(queryProcessor.process("Emily Bronte"), containsString("English novelist"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void willOnlyMatchTheFirstAuthor() throws Exception {
    	assertThat(queryProcessor.process("shakespeare asimov"), containsString("playwright"));
	assertThat(queryProcessor.process("shakespeare asimov"), is(not(containsString("science fiction"))));
    }
}
