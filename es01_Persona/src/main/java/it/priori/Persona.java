package it.priori;
/**
 * La classe Persona aiuta la sviluppatore a gestire dati di tipo Persona
 * 
 * @since JDK1.0
 */
public class Persona {
    private String nome, cognome, codice;

    /**
     * Costruisce un oggetto dato il nome, il cognome e il codice fiscale
     * (trasformato in automatico in maiuscolo). Se CF non e' valido, viene lanciata
     * un'eccezione.
     * <br>
     * <strong>CONTROLLO sul CODICE FISCALE:</strong>
     * <ul>
     * <li>Il codice deve contenere 16 caratteri alfanumerici</li>
     * <li>Il codice non deve contenere spazi</li>
     * <li>I primi 6 caratteri devono essere delle consonanti</li>
     * <li>Settimo e ottavo carattere devono essere numeri</li>
     * </ul>
     * Consulta la <a href=
     * "https://docs.oracle.com/javase/7/docs/api/java/lang/String.html">Documentazione
     * ufficiale String </a>
     *
     * @param nome    stringa qualsiasi da assegnare come nome di un nuovo oggetto
     *                Persona
     * @param cognome stringa qualsiasi da assegnare come cognome di un nuovo
     *                oggetto Persona
     * @param codice  stringa che rappresenta il nuovo codice fiscale dell'oggetto
     *                Persona
     * @throws IllegalArgumentException Se il codice fiscale fornito non e' valido
     */
    public Persona(String nome, String cognome, String codice) {
        if (isValidCode(codice)) {
            this.codice = codice.toUpperCase();
            this.nome = nome;
            this.cognome = cognome;
        } else {
            throw new IllegalArgumentException("Codice fiscale non valido: " + codice);
        }
    }

    /**
     * Il metodo stabilisce se due persone sono omonime; Restituisce un booleano:
     * VERO se le due persone hanno lo stesso nome (senza distinzione di maiuscole e
     * minuscole) altrimenti FALSO.
     * 
     * @param p oggetto Persona
     * @return Vero se le due persone confrontate hanno lo stesso nome, altrimenti
     *         falso
     */
    public boolean isOmonimo(Persona p) {
        String nome1 = this.nome;
        String nome2 = p.getNome();
        if (nome1.equalsIgnoreCase(nome2))
            return true;
        return false;
    }

    /**
     * restituisce una Stringa contenente il nome della persona
     * 
     * @return il nome di un oggetto Persona
     */
    public String getNome() {
        return nome;
    }

    /**
     * assegna una Stringa come nome di una persona
     * 
     * @param nome Stringa da assegnare come nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * restituisce una Stringa contenente il cognome della persona
     * 
     * @return il cognome di un oggetto Persona
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * assegna una Stringa come cognome di una persona
     * 
     * @param cognome nuova stringa da assegnare come cognome a un oggetto Persona
     *                già esistente
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce una rappresentazione testuale di un oggetto Persona, nel seguente
     * formato "NOME:xx COGNOME:xx CF:xx"
     * 
     * @return La rappresentazione testuale di un oggetto Persona
     */
    @Override
    public String toString() {
        return "NOME: " + nome + " COGNOME: " + cognome + " CF: " + codice;
    }

    private boolean isValidCode(String cod) {
        if (cod.length() != 16 || cod.contains(" ")) {
            return false;
        }
        String regex = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$";
        return cod.matches(regex);
    }
}
