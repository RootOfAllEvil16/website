package com.project.eva.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.project.eva.util.validator.ObjectValidator.isNotEmpty;
import static com.project.eva.util.validator.ObjectValidator.isNotNull;


@MappedSuperclass
public abstract class Model implements Serializable {

    private static final long serialVersionUID = 1L;


    private static final char[] CODE_PATTERN = "SHEISINME1234567890".toCharArray();


    private static final int CODE_LENGTH = 6;


    private static final String DATE_PATTERN = "EEE, d MMM yyyy, HH:mm:ss";


    private static final String TIME_ZONE = "GMT+3";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    protected Model() {
    }

    @Override
    public String toString() {
        return "Model{id=" + this.id + '}';
    }


    @Override
    public boolean equals(Object object) {
        return isNotNull(object) && (super.equals(object) || (getClass() == object.getClass()));
    }

    @Override
    public abstract int hashCode();


    protected String dateToString(final Date date) {
        return dateToStringWithFormat(date,
                new SimpleDateFormat(DATE_PATTERN),
                TimeZone.getTimeZone(TIME_ZONE)
        );
    }


    public long getId() {
        return this.id;
    }


    public void setId(final long id) {
        this.id = id;
    }


    public <T extends Model> List<T> getUnmodifiableList(final Collection<T> collection) {
        final List<T> result;
        if (isNotEmpty(collection)) {
            result = Collections.unmodifiableList(new ArrayList<>(collection));
        } else {
            result = new ArrayList<>();
        }
        return result;
    }


    private static String dateToStringWithFormat(
            final Date date,
            final DateFormat dateFormat,
            final TimeZone timeZone
    ) {
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(date);
    }
}
