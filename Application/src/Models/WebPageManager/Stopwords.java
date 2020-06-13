
package Models.WebPageManager;

import Models.FileManager.FileManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Stopwords {
    
    private static String stopWordsFile = "D:\\Documentos\\GitHub\\RIT_Proyecto2\\Data\\set_stopwords";
    private static String stopwordTerms = "a\n" +
        "aca\n" +
        "ahi\n" +
        "ajena\n" +
        "ajenas\n" +
        "ajeno\n" +
        "ajenost\n" +
        "al\n" +
        "algo\n" +
        "algun\n" +
        "alguna\n" +
        "algunas\n" +
        "alguno\n" +
        "algunos\n" +
        "alla\n" +
        "alli\n" +
        "alli\n" +
        "ambos\n" +
        "ampleamos\n" +
        "ante\n" +
        "antes\n" +
        "aquel\n" +
        "aquella\n" +
        "aquellas\n" +
        "aquello\n" +
        "aquellos\n" +
        "aqui\n" +
        "aqui\n" +
        "arriba\n" +
        "asi\n" +
        "atras\n" +
        "aun\n" +
        "aunque\n" +
        "bajo\n" +
        "bastante\n" +
        "bien\n" +
        "cabe\n" +
        "cada\n" +
        "casi\n" +
        "cierta\n" +
        "ciertas\n" +
        "cierto\n" +
        "ciertos\n" +
        "como\n" +
        "como\n" +
        "con\n" +
        "conmigo\n" +
        "conseguimos\n" +
        "conseguir\n" +
        "consigo	consigue\n" +
        "consiguen\n" +
        "consigues\n" +
        "contigo\n" +
        "contra\n" +
        "cual\n" +
        "cuales\n" +
        "cualquier\n" +
        "cualquiera\n" +
        "cualquieras\n" +
        "cuan\n" +
        "cuan\n" +
        "cuando\n" +
        "cuanta\n" +
        "cuanta\n" +
        "cuantas\n" +
        "cuantas\n" +
        "cuanto\n" +
        "cuanto\n" +
        "cuantos\n" +
        "cuantos\n" +
        "de\n" +
        "dejar\n" +
        "del\n" +
        "demas\n" +
        "demas\n" +
        "demasiada\n" +
        "demasiadas\n" +
        "demasiado\n" +
        "demasiados\n" +
        "dentro\n" +
        "desde\n" +
        "donde\n" +
        "dos\n" +
        "el\n" +
        "el\n" +
        "ella\n" +
        "ellas\n" +
        "ello\n" +
        "ellos\n" +
        "empleais\n" +
        "emplean\n" +
        "emplear\n" +
        "empleas\n" +
        "empleo\n" +
        "en\n" +
        "encima\n" +
        "entonces\n" +
        "entre\n" +
        "era	eramos\n" +
        "eran\n" +
        "eras\n" +
        "eres\n" +
        "es\n" +
        "esa\n" +
        "esas\n" +
        "ese\n" +
        "eso\n" +
        "esos\n" +
        "esta\n" +
        "estaba\n" +
        "estado\n" +
        "estais\n" +
        "estamos\n" +
        "estan\n" +
        "estar\n" +
        "estas\n" +
        "este\n" +
        "esto\n" +
        "estos\n" +
        "estoy\n" +
        "etc\n" +
        "fin\n" +
        "fue\n" +
        "fueron\n" +
        "fui\n" +
        "fuimos\n" +
        "gueno\n" +
        "ha\n" +
        "hace\n" +
        "haceis\n" +
        "hacemos\n" +
        "hacen\n" +
        "hacer\n" +
        "haces\n" +
        "hacia\n" +
        "hago\n" +
        "hasta\n" +
        "incluso\n" +
        "intenta\n" +
        "intentais\n" +
        "intentamos\n" +
        "intentan\n" +
        "intentar\n" +
        "intentas\n" +
        "intento\n" +
        "ir\n" +
        "jamas\n" +
        "junto	juntos\n" +
        "la\n" +
        "largo\n" +
        "las\n" +
        "lo\n" +
        "los\n" +
        "mas\n" +
        "mas\n" +
        "me\n" +
        "menos\n" +
        "mi\n" +
        "mia\n" +
        "mia\n" +
        "mias\n" +
        "mientras\n" +
        "mio\n" +
        "mio\n" +
        "mios\n" +
        "mis\n" +
        "misma\n" +
        "mismas\n" +
        "mismo\n" +
        "mismos\n" +
        "modo\n" +
        "mucha\n" +
        "muchas\n" +
        "muchisima\n" +
        "muchisimas\n" +
        "muchisimo\n" +
        "muchisimos\n" +
        "mucho\n" +
        "muchos\n" +
        "muy\n" +
        "nada\n" +
        "ni\n" +
        "ningun\n" +
        "ninguna\n" +
        "ningunas\n" +
        "ninguno\n" +
        "ningunos\n" +
        "no\n" +
        "nos\n" +
        "nosotras\n" +
        "nosotros\n" +
        "nuestra\n" +
        "nuestras\n" +
        "nuestro\n" +
        "nuestros\n" +
        "nunca\n" +
        "os	otra\n" +
        "otras\n" +
        "otro\n" +
        "otros\n" +
        "para\n" +
        "parecer\n" +
        "pero\n" +
        "poca\n" +
        "pocas\n" +
        "poco\n" +
        "pocos\n" +
        "podeis\n" +
        "podemos\n" +
        "poder\n" +
        "podria\n" +
        "podriais\n" +
        "podriamos\n" +
        "podrian\n" +
        "podrias\n" +
        "por\n" +
        "por que\n" +
        "porque\n" +
        "primero\n" +
        "puede\n" +
        "pueden\n" +
        "puedo\n" +
        "pues\n" +
        "que\n" +
        "que\n" +
        "querer\n" +
        "quien\n" +
        "quien\n" +
        "quienes\n" +
        "quienesquiera\n" +
        "quienquiera\n" +
        "quiza\n" +
        "quizas\n" +
        "sabe\n" +
        "sabeis\n" +
        "sabemos\n" +
        "saben\n" +
        "saber\n" +
        "sabes\n" +
        "se\n" +
        "segun\n" +
        "ser\n" +
        "si\n" +
        "si\n" +
        "siempre\n" +
        "siendo	sin\n" +
        "sin\n" +
        "sino\n" +
        "so\n" +
        "sobre\n" +
        "sois\n" +
        "solamente\n" +
        "solo\n" +
        "somos\n" +
        "soy\n" +
        "sr\n" +
        "sra\n" +
        "sres\n" +
        "sta\n" +
        "su\n" +
        "sus\n" +
        "suya\n" +
        "suyas\n" +
        "suyo\n" +
        "suyos\n" +
        "tal\n" +
        "tales\n" +
        "tambien\n" +
        "tambien\n" +
        "tampoco\n" +
        "tan\n" +
        "tanta\n" +
        "tantas\n" +
        "tanto\n" +
        "tantos\n" +
        "te\n" +
        "teneis\n" +
        "tenemos\n" +
        "tener\n" +
        "tengo\n" +
        "ti\n" +
        "tiempo\n" +
        "tiene\n" +
        "tienen\n" +
        "toda\n" +
        "todas\n" +
        "todo\n" +
        "todos\n" +
        "tomar\n" +
        "trabaja\n" +
        "trabajais\n" +
        "trabajamos\n" +
        "trabajan\n" +
        "trabajar\n" +
        "trabajas	trabajo\n" +
        "tras\n" +
        "tu\n" +
        "tu\n" +
        "tus\n" +
        "tuya\n" +
        "tuyo\n" +
        "tuyos\n" +
        "ultimo\n" +
        "un\n" +
        "una\n" +
        "unas\n" +
        "uno\n" +
        "unos\n" +
        "usa\n" +
        "usais\n" +
        "usamos\n" +
        "usan\n" +
        "usar\n" +
        "usas\n" +
        "uso\n" +
        "usted\n" +
        "ustedes\n" +
        "va\n" +
        "vais\n" +
        "valor\n" +
        "vamos\n" +
        "van\n" +
        "varias\n" +
        "varios\n" +
        "vaya\n" +
        "verdad\n" +
        "verdadera\n" +
        "vosotras\n" +
        "vosotros\n" +
        "voy\n" +
        "vuestra\n" +
        "vuestras\n" +
        "vuestro\n" +
        "vuestros\n" +
        "y\n" +
        "ya\n" +
        "yo"; 
    
    private static Set<String> WriteStopwords(){
        Set<String> setStopWords =  new HashSet<String>();
        String[] stopwords = Stopwords.stopwordTerms.split("\n");
        setStopWords.addAll(Arrays.asList(stopwords));
        FileManager.writeObject(setStopWords, stopWordsFile);
        return setStopWords;
    }
    
    public static Set<String> LoadStopWords(){
        Set<String> setStopWords = (Set<String>) FileManager.readObject(stopWordsFile);
        if(setStopWords == null) return WriteStopwords();
        else return setStopWords;
    }
}