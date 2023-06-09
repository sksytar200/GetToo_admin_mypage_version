package Group2.capstone_project.service;


import Group2.capstone_project.domain.Board;
import Group2.capstone_project.domain.Client;
import Group2.capstone_project.repository.ClientRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;


public class clientService {

    PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    private final ClientRepository clientRepository ;

    public clientService(ClientRepository clientRepository) {this.clientRepository = clientRepository;}


    public void join(Client client) {
        validateDuplicateMember(client);
        clientRepository.save(Optional.of(client));
    }

    private void validateDuplicateMember(Client client) {
        clientRepository.findById(client.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 id입니다");
                });
    }

    public String findId(String clientName, String clientStudentNumber, String clientEmail) {
        Optional<Client> client = clientRepository.findId(clientName, clientStudentNumber,clientEmail);
        if(client.isPresent())
            return client.get().getId();
        else
            return "false";
    }

    public String findPwd(String clientName, String clientId, String clientStudentNumber, String clientEmail) {
        Optional<Client> client = clientRepository.findPwd(clientName, clientId, clientStudentNumber, clientEmail);
        return client.get().getPwd();
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> login(Client client) {
        Optional<Client> result = clientRepository.login(client);
        if (result.isPresent()) {

            Client chkclient = result.get();
            if (passwordEncoder.matches(client.getPwd(),chkclient.getPwd())) {
                return result;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Client updateForm(String id){
        if(clientRepository.findById(id).isPresent()) {
            Client client = clientRepository.findById(id).get();
            return client;
        }
        else{
            return null;
        }

    }

    public  Client findById(String id){
        return clientRepository.findById(id).get();
    }
    public void updateInfo(Client client){
        clientRepository.updateInfo(client);
    }

    public void joinAuth(String id){
        clientRepository.authJoin(id);
    }
    public boolean checkIdAvailability(String id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return !optionalClient.isPresent();
    }

//    public List<Client> getClientInfo() {
//        return clientRepository.findAll();
//    }
    public void save(Client client){
    clientRepository.save(Optional.ofNullable(client));
}

}

