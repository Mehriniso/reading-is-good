package com.mkamalova.readingisgood.enumaration;

public enum EnumResponseMessage
{
    RC_SUCCESS("RC000","Başarılı işlem."),
    RC_ERROR("RC999","Beklenmeyen hata oluştu."),
    RC_BOOK_STOCK_ERROR("RC001", "Sipariş verilen stok sayısı, mevcutta bulunan stok sayısını aşmaktadır."),
    RC_BOOK_IS_NOT_EXIST("RC002", "Kitap id değeri eşleşmiyor."),
    RC_INVALID_REQUEST("RC003", " Lütfen giriş değerlerini kontrol ediniz.");
    //RC_NO_CUTOMER_FOUND("RC004", "Müşteri bulunamadı. Lütfen müşteri id {customer_id} değerini kontrol ediniz.");

    private  String responseCode;
    private  String responseDescription;

    EnumResponseMessage(String responseCode, String responseDescription) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
    }

    public String getResponseCode()
    {return responseCode;}

    public String getResponseDesc()
    {return responseDescription;}

}
