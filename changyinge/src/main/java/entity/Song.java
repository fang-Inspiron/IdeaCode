package entity;

/**
 * Created by alber on 2016/8/30.
 */
public class Song {
    private long songId;
    private String songName;
    private String singgerName;
    private String albumName;
    private String albumpicBig;
    private String albumpicSma;
    private String downurl;
    private String m4a;
    private int seconds;
    private String category;
    private String lrc;
    private long collectionsCount;
    private long commentCount;
    private long downloadCount;
    private long hot;

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinggerName() {
        return singgerName;
    }

    public void setSinggerName(String singgerName) {
        this.singgerName = singgerName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumpicBig() {
        return albumpicBig;
    }

    public void setAlbumpicBig(String albumpicBig) {
        this.albumpicBig = albumpicBig;
    }

    public String getAlbumpicSma() {
        return albumpicSma;
    }

    public void setAlbumpicSma(String albumpicSma) {
        this.albumpicSma = albumpicSma;
    }

    public String getDownurl() {
        return downurl;
    }

    public void setDownurl(String downurl) {
        this.downurl = downurl;
    }

    public String getM4a() {
        return m4a;
    }

    public void setM4a(String m4a) {
        this.m4a = m4a;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    public long getCollectionsCount() {
        return collectionsCount;
    }

    public void setCollectionsCount(long collectionsCount) {
        this.collectionsCount = collectionsCount;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    public long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(long downloadCount) {
        this.downloadCount = downloadCount;
    }

    public long getHot() {
        return hot;
    }

    public void setHot(long hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", singgerName='" + singgerName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumpicBig='" + albumpicBig + '\'' +
                ", albumpicSma='" + albumpicSma + '\'' +
                ", downurl='" + downurl + '\'' +
                ", m4a='" + m4a + '\'' +
                ", seconds=" + seconds +
                ", category='" + category + '\'' +
                ", lrc='" + lrc + '\'' +
                ", collectionsCount=" + collectionsCount +
                ", commentCount=" + commentCount +
                ", downloadCount=" + downloadCount +
                ", hot=" + hot +
                '}'+"\n";
    }
}
