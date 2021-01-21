package ic.doc;

public class QueryProcessor {

    public String process(String query) {
        StringBuilder results = new StringBuilder();
        if (query.toLowerCase().contains("shakespeare")) {
            results.append("William Shakespeare (26 April 1564 - 23 April 1616) was an\n" +
                           "English poet, playwright, and actor, widely regarded as the greatest\n" +
                           "writer in the English language and the world's pre-eminent dramatist. \n");
            results.append(System.lineSeparator());

        } else if (query.toLowerCase().contains("asimov")) {
            results.append("Isaac Asimov (2 January 1920 - 6 April 1992) was an\n" +
                           "American writer and professor of Biochemistry, famous for\n" +
                           "his works of hard science fiction and popular science. \n");
            results.append(System.lineSeparator());
        } else if (query.toLowerCase().contains("james baldwin")) {
	    results.append("James Arthur Baldwin was an American novelist, playwright\n" + 
			   "essayist, poet, and activist. His essays, as collected in Notes of\n" +
			   " a Native Son, explore intricacies of racial, sexual, and class distinctions\n" + 
			   "in Western society, most notably in regard to the mid-twentieth-century United States.\n");
	    results.append(System.lineSeparator());
	} else if (query.toLowerCase().contains("emily bronte")) {
	    results.append("Emily Jane Brontë (/ˈbrɒnti/, commonly /-teɪ/;[2] 30 July 1818 – 19 December 1848)\n" + 
			   "was an English novelist and poet who is best known for her only novel, Wuthering Heights\n" + 
			   ", now considered a classic of English literature.");
	    results.append(System.lineSeparator());
	}
        return results.toString();
    }
}
