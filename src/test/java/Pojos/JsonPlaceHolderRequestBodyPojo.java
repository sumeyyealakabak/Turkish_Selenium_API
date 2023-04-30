package Pojos;

public class JsonPlaceHolderRequestBodyPojo {
    /*
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */



    // 1 - Tum key degerlerini class levelda, aldiklari data
    // turune gore private variable olarak olusturalim

    private  String title;
    private String body;
    private int userId;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 3 - Tum variablelari iceren parametreli bir constructor olusturalim


    public JsonPlaceHolderRequestBodyPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }
    // 4 - Parametreli constructor olusturdugum icin bir tane de parametresiz constructor olusturuyorum

    public JsonPlaceHolderRequestBodyPojo() {
    }

    // 5 - toString() olusturuyorum

    @Override
    public String toString() {
        return "JsonPlaceHolderRequestBodyPojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }


}
