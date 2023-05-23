class Production{
    private String title,writer,director;
    Production(){};
    public Production(String title, String director, String writer){
        this.title=title;
        this.director=director;
        this.writer=writer;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getTitle() {
        return title;
    }
    public String getDirector() {
        return director;
    }
    public String getWriter() {
        return writer;
    }
    public String tostring() {
        return "The production "+title + " is directed by " + director + " and written by " + writer + "\n";
    }
    public int no_of_seats;
    public static int BOC=0;
    public static int getBOC(){
        return BOC;
    }
}
class Play extends Production{
    private static int performances=0;
    public Play(){}
    public Play(String title, String director, String writer,int seats){
        super(title, director, writer);
        no_of_seats=seats;
        performances++;
    }
    public void incr_boc_play(){
        BOC+=500*no_of_seats;
    }
    @Override
    public String tostring() {
        return "The play "+getTitle() + " is directed by " + getDirector() + " and written by " + getWriter()+ ".\n" +
                "With "+no_of_seats+" seats sold and a Box office collection of "+this.no_of_seats*500 + " rupees.\n";
    }
    public static void incr_performances(){
        performances++;
    }
    static int getPerformances(){
        return performances;
    }

}
class Musical extends Play{
    private String composer,lyricist;
    public Musical(String title, String director, String writer,String composer, String lyricist,int seats){
        super(title, director, writer,seats);
        this.composer=composer;
        this.lyricist=lyricist;
    }

    public void incr_boc_musical(){
        BOC+=800*no_of_seats;
    }
    public void setComposer(String composer) {
        this.composer = composer;
    }
    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }
    public String getComposer() {
        return composer;
    }
    public String getLyricist() {
        return lyricist;
    }
    @Override
    public String tostring(){
        return "The musical "+getTitle() + " is directed by " + getDirector() + " and written by " + getWriter()+ " with music by "
                +getComposer() + " and lyrics by "+ getLyricist()+".\nWith "+no_of_seats+" seats sold and a Box office collection of "+this.no_of_seats*800 + " rupees.\n";
    }
}
public class Tester {
    public static void main(String[] args) {
        Musical[] musicalarr=new Musical[2];
        Play[] playarr=new Play[3];
        playarr[0]=new Play("Macbeth","Dir1","Shakespeare",27);
        playarr[1]=new Play("Andha Yug","Dir2","Dharamveer Bharati",22);
        playarr[2]=new Play("Shakuntala","Dir3","Kalidasa",31);
        musicalarr[0]=new Musical("Yayati","Dir4","Girish Karnad","composer1","lyricist1", 29);
        musicalarr[1]=new Musical("Natsamrat","Dir5","Girish Karnad","composer2","lyricist2", 33);
        for(int i=0;i<3;i++){
            playarr[i].incr_boc_play();
        }
        for(int i=0;i<2;i++){
            musicalarr[i].incr_boc_musical();
        }
        for(int i=0;i<3;i++){
            System.out.printf(playarr[i].tostring());
        }
        for(int i=0;i<2;i++){
            System.out.printf(musicalarr[i].tostring());
        }
        System.out.printf("The total Box office collection of all 5 productions is %d.\n", Production.getBOC());
    }
}
