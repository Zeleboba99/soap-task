package com.example.soaptask.endpoint;

import com.example.soaptask.repository.PersonRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import spring.soap.GetPersonRequest;
import spring.soap.GetPersonResponse;
import spring.soap.Person;

@Endpoint
public class PersonEndpoint {
    private static final String NAMESPACE_URI = "http://spring/soap";
    private static final Logger log = Logger.getLogger(PersonEndpoint.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    public PersonEndpoint(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getPerson(@RequestPayload GetPersonRequest request){
        log.info("start method getPerson");
        GetPersonResponse response = new GetPersonResponse();
        Person person = personRepository.findPersonByName(request.getName());
        response.setPerson(person);
        return response;
    }
}
