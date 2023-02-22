enum SQLQuery {
    ;

    static final String GET_VILLAINS_NAMES = "select concat(name,' ', count(distinct mv.minion_id)) as output from villains" +
            " join minions_villains mv on villains.id = mv.villain_id" +
            " group by villains.name" +
            " having count(distinct mv.minion_id) > ?" +
            " order by count(distinct mv.minion_id) desc";


    static final String GET_MINIONS_NAMES = "select m.name, m.age from minions m" +
            " join minions_villains mv on m.id = mv.minion_id" +
            " join villains v on v.id = mv.villain_id" +
            " where v.id = ?";
    static final String ADD_VILLAIN = "insert into villains (name, evilness_factor)" +
            " select ?, 'evil' from dual" +
            " where not exists(select * from villains" +
            " where name = ?)";
    static final String ADD_TOWN = "insert into towns (name, country)" +
            " select ?, null from dual" +
            " where not exists(select * from towns" +
            " where name = ?)";

    static final String ADD_MINION = "insert into minions (name, age, town_id)" +
            " values (?, ?, ?)";

    static final String INSERT_INTO_MINIONS_VILLAINS = "insert into minions_villains (minion_id, villain_id)" +
            " values (?, ?)";
    static final String GET_TOWN_ID = "call usp_get_town_id(?)";
    static final String GET_VILLAIN_ID = "call usp_get_villain_id(?)";
    static final String GET_MINION_ID = "call usp_get_minion_id(?)";

    static final String CHANGE_TOWN_NAMES = "call usp_change_town_names(?)";

    static final String GET_COUNT_OF_TOWNS = "select count(*)" +
            " from towns" +
            " where country = ?";

    static final String GET_FORMATTED_TOWN_NAMES = "select concat('[',group_concat(distinct name separator ', '),']') as country_name" +
            " from towns" +
            " where country = ?";

    static final String GET_COUNT_OF_MINIONS = "select count(*)" +
            " from minions" +
            " join minions_villains mv on minions.id = mv.minion_id" +
            " join villains v on v.id = mv.villain_id" +
            " where v.id = ?";

    static final String GET_VILLAIN_NAME_BY_ID = "select name" +
            " from villains" +
            " where id = ?";

    static final String DELETE_FROM_MINIONS_VILLAINS_BY_VILLAIN_ID = "delete from minions_villains as mv" +
            " where mv.villain_id = ?";

    static final String DELETE_FROM_VILLAINS_BY_VILLAIN_ID = "delete from villains as v" +
            " where v.id = ?";

    static final String GET_ALL_MINION_NAMES = "select name from minions";

    static final String INCREASE_MINION_AGE = "call usp_increase_minion_age(?)";

    static final String MAKE_MINION_NAME_LOWER_CASE = "call usp_make_minion_name_lower_case(?)";

    static final String GET_MINION_NAME_AND_AGE = "select concat(name, ' ', age) as output" +
            " from minions";

    static final String GET_OLDER = "call usp_get_older(?);";

    static final String GET_MINION_NAME_AND_AGE_BY_GIVEN_ID = "select concat(name, ' ', age) output" +
            " from minions" +
            " where id = ?";

    // SQL Procedures
    private static final String USP_GET_TOWN_ID = "delimiter $$" +
            " create procedure usp_get_town_id(town_name varchar(50))" +
            " begin" +
            " select id from towns" +
            " where name = town_name;" +
            " end $$";
    private static final String USP_GET_VILLAIN_ID = "delimiter $$" +
            " create procedure usp_get_villain_id(villain_name varchar(50))" +
            " begin" +
            " select id from villains" +
            " where name = villain_name;" +
            " end $$";
    private static final String USP_GET_MINION_ID = "delimiter $$" +
            " create procedure usp_get_minion_id(minion_name varchar(50))" +
            " begin" +
            " select id from minions" +
            " where name = minion_name;" +
            " end $$";

    private static final String USP_CHANGE_TOWN_NAMES = "delimiter $$" +
            " create procedure usp_change_town_names(country_name varchar(50))" +
            " begin" +
            " update towns" +
            " set name = upper(name)" +
            " where country = country_name;" +
            " end$$";

    private static final String USP_INCREASE_MINION_AGE = "delimiter $$" +
            " create procedure usp_increase_minion_age(minion_id int)" +
            " begin" +
            " update minions" +
            " set age = age + 1" +
            " where id = minion_id" +
            " end$$";

    private static final String USP_MAKE_MINION_NAME_LOWER_CASE = "delimiter $$" +
            " create procedure usp_make_minion_name_lower_case(minion_id int)" +
            " begin" +
            " update minions" +
            " set name = upper(name)" +
            " where id = minion_id;" +
            " end$$";

    private static final String USP_GET_OLDER = "delimiter $$" +
            " create procedure usp_get_older(minion_id int)" +
            " begin" +
            " update minions" +
            " set age = age + 1" +
            " where id = minion_id;" +
            " end$$";
}
