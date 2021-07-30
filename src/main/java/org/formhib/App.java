package org.formhib;

import org.formhib.utils.SessionHibernate;

public class App {
    public static void main(String[] args) {
        SessionHibernate.currentSession();
        SessionHibernate.closeSession();
    }

}
