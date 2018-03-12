package zsc.gof.entity;

public class ChapterDetailed {

	private int detailedId;
	private int chapterId;
	private String detailedTile;
	private String videoUrl;

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public ChapterDetailed(int detailedId, int chapterId, String detailedTile, String videoUrl) {
		this.detailedId = detailedId;
		this.chapterId = chapterId;
		this.detailedTile = detailedTile;
		this.videoUrl = videoUrl;
	}

	public ChapterDetailed() {
	}

	public int getDetailedId() {
		return detailedId;
	}

	public void setDetailedId(int detailedId) {
		this.detailedId = detailedId;
	}

	public String getDetailedTile() {
		return detailedTile;
	}

	public void setDetailedTile(String detailedTile) {
		this.detailedTile = detailedTile;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
}
