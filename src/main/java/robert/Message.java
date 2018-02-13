package robert;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name="content")
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;


  @Column(name="text",nullable=false)
  private String text;

  public Message(String message) {
    this.text=message;
  }

  public Message() {

  }

  public String toString() {
    return text;
  }
}
