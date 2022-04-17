package net.jordimp.katas.katas.basics;

public class DnaStrand {

        public static String makeComplement(String dna) {
            StringBuilder sb = new StringBuilder();
            for (char c : dna.toCharArray()) {
                sb.append(DNA.valueOf(String.valueOf(c)).getComplement());
            }
            return sb.toString();
        }

    public enum DNA {
        A("T"), T("A"), G("C"), C("G");

        private final String complement;

        DNA(String complement) {
            this.complement = complement;
        }

        public String getComplement() {
            return complement;
        }
    }
}
