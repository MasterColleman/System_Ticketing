package com.sergio.TicketSystemApp.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TicketHashtags {

    public ArrayList<String> getHashtagsListToTicket() {
        return hashtagsListToTicket;
    }

    private String Hashtags;//palabras clave del campo Etiquetas
    private TicketServiceType serviceType;
    private ArrayList<String> hashtagsListToTicket;//lista final desplegable de palabras clave que aparece en Ticket
    private ArrayList<String> technicalSupportAndServiceList;
    private ArrayList<String> micro_ConsultingList;
    private ArrayList<String> assemblyList;

    public TicketHashtags(){
        technicalSupportAndServiceList = new ArrayList<String>();
        technicalSupportAndServiceList.add("Mantenimiento");
        technicalSupportAndServiceList.add("Correctivo");
        technicalSupportAndServiceList.add("Preventivo");
        technicalSupportAndServiceList.add("Predictivo");
        technicalSupportAndServiceList.add("Diagnostico");
        technicalSupportAndServiceList.add("Reparacion");
        technicalSupportAndServiceList.add("Instalacion");
        technicalSupportAndServiceList.add("Configuracion");
        technicalSupportAndServiceList.add("Cambio-de-Partes");
        technicalSupportAndServiceList.add("Software");
        technicalSupportAndServiceList.add("Hardware");
        micro_ConsultingList = new ArrayList<String>();
        micro_ConsultingList.add("Instalacion");
        micro_ConsultingList.add("Cotizacion");
        micro_ConsultingList.add("Comparativa");
        micro_ConsultingList.add("Diseño");
        micro_ConsultingList.add("Asesoramiento");
        assemblyList = new ArrayList<String>();
        assemblyList.add("Modding");
        assemblyList.add("Presupuesto");
        assemblyList.add("Actualizacion");
        assemblyList.add("Overclocking");
        assemblyList.add("Configuracion");
    }

    //Metodo para agregar palabra clave una lista especifica de palabras clave de acuerdo a tipo de servicio
    public void addKeywordToSpecificServiceList(@NotNull TicketServiceType serviceType, String Keyword){
        switch (serviceType){
            case technicalService,technicalSupport -> this.technicalSupportAndServiceList.add(Keyword);
            case assembly -> this.assemblyList.add(Keyword);
            case micro_Consulting -> this.micro_ConsultingList.add(Keyword);
        }
    }

    //Metodo para habilitar una lista de palabras clave especificas a cada tipo de servicio
    public void enableHashtagList(@NotNull TicketServiceType serviceType){
        switch (serviceType){
            case technicalService, technicalSupport -> this.hashtagsListToTicket = this.technicalSupportAndServiceList;
            case assembly -> this.hashtagsListToTicket = this.assemblyList;
            case micro_Consulting -> this.hashtagsListToTicket = this.micro_ConsultingList;
        }
    }

    private void setHashtags(String hashtags) {
        Hashtags = hashtags;
    }

    public String getHashtags() {
        return Hashtags;
    }

    //Metodos para añadir las palabras clave a "Etiquetas"

    public void addWordsToHashtags(@NotNull String hashtagsIn){
        if(hashtagsIn.length()>=20&&hashtagsIn.length()<=90)
            setHashtags(hashtagsIn);

    }
    public void addWordsToHashtags(String key1,String key2,String key3,String key4, String key5,
                                   String key6, String key7, String key8, String key9){
        String hashtagsIn = key1 + " " + key2 + " " + key3 + " " + key4 + " " + key5 + " " + key6
                + " " + key7 + " " + key8 + " " + key9;
        if(hashtagsIn.length()>=20&&hashtagsIn.length()<=90)
            setHashtags(hashtagsIn);
    }
    public void addWordsToHashtags(String key1,String key2,String key3,String key4, String key5){
        String hashtagsIn = key1 + " " + key2 + " " + key3 + " " + key4 + " " + key5;
        if(hashtagsIn.length()>=20&&hashtagsIn.length()<=70)
            setHashtags(hashtagsIn);
    }

}
