package com.CRUD2.StoreProject1.repository;

import com.CRUD2.StoreProject1.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client> getClients(){
    var clients = new ArrayList<Client>();

    String sql = "SELECT * FROM clients ORDER BY id DESC";
    SqlRowSet rows =jdbcTemplate.queryForRowSet(sql);

    while(rows.next()){
        Client client = new Client();
        client.setId(rows.getInt("id"));
        client.setFirstName(rows.getString("firstName"));
        client.setLastName(rows.getString("lastName"));
        client.setEmail(rows.getString("email"));
        client.setPhone(rows.getString("phone"));
        client.setAddress(rows.getString("address"));
        client.setCreatedAt(rows.getString("created_at"));

        clients.add(client);

    }

    return clients;
    }
}
