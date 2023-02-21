enum Constants {
    ;
    static final String USER_KEY = "user";
    static final String USER_VALUE = "root";
    static final String PASSWORD_KEY = "password";
    static final String PASSWORD_VALUE = "1234";

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/minions_db";


    //SQL Procedures
    static final String GET_TOWN_ID = "delimiter $$" +
            " create procedure usp_get_town_id(town_name varchar(50))" +
            " begin" +
            " select id from towns" +
            " where name = town_name;" +
            "end $$";
    static final String GET_VILLAIN_ID = "delimiter $$" +
            " create procedure usp_get_villain_id(villain_name varchar(50))" +
            " begin" +
            " select id from villains" +
            " where name = villain_name;" +
            "end $$";
    static final String GET_MINION_ID = "delimiter $$" +
            " create procedure usp_get_minion_id(minion_name varchar(50))" +
            " begin" +
            " select id from minions" +
            " where name = minion_name;" +
            "end $$";
}
