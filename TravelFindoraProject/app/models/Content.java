package models;

import play.data.validation.Required;
import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by thomas on 25/05/15.
 */
@Entity
public abstract class Content extends GenericModel {
    @Id
    @GeneratedValue
    private int contentId;

    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name="TRAVEL_TRAVELID")
    @Required
    private Travel travel; //a debattre User ou Travel, est ce qu'un utilisateur qui n'a pas forcément voyager peut poster sur ce findora ? Cela complexifie la gestion des travels

    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name="FINDORA_FINDORAID")
    @Required
    private Findora findora;

    @OneToMany(mappedBy="content", fetch = FetchType.EAGER)
    private Set<CommentaireContent> commentaires;

    @OneToMany(mappedBy = "likingContent", cascade = CascadeType.ALL)
    private Set<ContentLike> likers;

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public Findora getFindora() {
        return findora;
    }

    public void setFindora(Findora findora) {
        this.findora = findora;
    }

    public Set<CommentaireContent> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Set<CommentaireContent> commentaires) {
        this.commentaires = commentaires;
    }

    public Set<ContentLike> getLikers() {
        return likers;
    }

    public void setLikers(Set<ContentLike> likers) {
        this.likers = likers;
    }

    public int getContentId() {
        return contentId;
    }
}
