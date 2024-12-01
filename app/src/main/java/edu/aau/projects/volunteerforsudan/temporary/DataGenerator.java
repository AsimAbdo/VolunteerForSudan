package edu.aau.projects.volunteerforsudan.temporary;

import java.util.ArrayList;
import java.util.List;

import edu.aau.projects.volunteerforsudan.models.ServiceRequest;

public class DataGenerator {
    public static List<ServiceRequest> getServices(){
        List<ServiceRequest> serviceRequests = new ArrayList<>();
        //demo data instead of real data from firebase
        for (int i = 0; i < 5; i++) {
            serviceRequests.add(new ServiceRequest("Food Services", "Asim", "North", 2211.0, "2024-09-12"));
            serviceRequests.add(new ServiceRequest("Treatment Services", "Mizo", "West", 3451.0, "2024-03-02"));
            serviceRequests.add(new ServiceRequest("Displacement Services", "Osman", "South", 2931.0, "2024-11-1"));
            serviceRequests.add(new ServiceRequest("Construction Services", "Ali", "East", 931.0, "2024-05-22"));
            serviceRequests.add(new ServiceRequest("Food Services", "Mona", "North", 2211.0, "2024-09-12"));
            serviceRequests.add(new ServiceRequest("Treatment Services", "Emma", "West", 3451.0, "2024-03-02"));
            serviceRequests.add(new ServiceRequest("Displacement Services", "Salma", "South", 2931.0, "2024-11-1"));
            serviceRequests.add(new ServiceRequest("Construction Services", "Fatima", "East", 931.0, "2024-05-22"));
            serviceRequests.add(new ServiceRequest("Food Services", "Omer", "North", 2211.0, "2024-09-12"));
            serviceRequests.add(new ServiceRequest("Treatment Services", "Malaz", "West", 3451.0, "2024-03-02"));
            serviceRequests.add(new ServiceRequest("Displacement Services", "Samir", "South", 2931.0, "2024-11-1"));
            serviceRequests.add(new ServiceRequest("Construction Services", "Aysha", "East", 931.0, "2024-05-22"));
        }

        return serviceRequests;
    }

    public static List<ServiceRequest> getServicesByType(List<ServiceRequest> serviceRequests,String servicetype){
        if (servicetype.equals("All Services"))
            return serviceRequests;
        else {
            List<ServiceRequest> newRequests = new ArrayList<>();
            for (int i = 0; i < serviceRequests.size(); i++) {
                if (serviceRequests.get(i).getType().equals(servicetype))
                    newRequests.add(serviceRequests.get(i));
            }
            return newRequests;
        }
    }

    public static List<ServiceRequest> getServicesByVolunteer(String volunteer) {
        List<ServiceRequest> requests = getServices();
        List<ServiceRequest> newRequests = new ArrayList<>();
        for (int i = 0; i < requests.size(); i++) {
            if (requests.get(i).getVolunteer().toLowerCase().contains(volunteer.toLowerCase()))
                newRequests.add(requests.get(i));
        }
        return newRequests;
    }
}
