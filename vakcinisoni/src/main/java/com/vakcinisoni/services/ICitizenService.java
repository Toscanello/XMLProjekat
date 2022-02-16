package com.vakcinisoni.services;

import com.vakcinisoni.models.Citizen;
import com.vakcinisoni.models.Credentials;

public interface ICitizenService {

    String register(Citizen citizen);

    String login(Credentials credentials);
}
