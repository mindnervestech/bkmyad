package viewmodel;

import java.text.SimpleDateFormat;

import models.Announcement;


public class AnnouncementVM {
     public long id;
     public String title;
     public String description;
     public String type;
     public String fromDate;
     public String toDate;

    SimpleDateFormat formatter = new SimpleDateFormat("MMMM-dd-yyyy");
    public AnnouncementVM(Announcement announcement) {
        this.id = announcement.id;
        this.title = announcement.title;
        this.type= announcement.announcementType;
        this.description = announcement.description;
        this.fromDate = formatter.format(announcement.fromDate);
        this.toDate = formatter.format(announcement.toDate);
    }
    
	
}
