package main.notebook;

/**
 * Note consists subscriber data
 * Created by Сергей on 03.05.2016.
 */
public class Note {

    /**
     * subscriber surname
     */
    private String surname;

    /**
     * subscriber name
     */
    private String name;

    /**
     * subscriber middle name
     */
    private String middleName;

    /**
     * subscriber short name
     */
    private String shortName;

    /**
     * subscriber nickname
     */
    private String nickname;
    /**
     * comment to subscriber note
     */
    private String comment;
    /**
     * subscriber contact group
     */
    private SubscriberGroup group;

    /**
     * subscriber home number
     */
    private String homeNumber;

    /**
     * subscriber mobile number
     */
    private String mobileNumber;

    /**
     * subscriber email
     */
    private String email;

    /**
     * subscriber skype contact
     */
    private String skype;

    /**
     * subscriber address index
     */
    private String addressIndex;

    /**
     * subscriber city
     */
    private String city;

    /**
     * subscriber street
     */
    private String street;

    /**
     * subscriber house number
     */
    private String houseNumber;

    /**
     * subscriber apartment number
     */
    private String apartmentNumber;

    /**
     * subscriber mail-rule address
     */
    private String mailFormAddress;

    /**
     * subscriber common address
     */
    private String commonFormAddress;

    /**
     * date when note was created
     */
    private String creationDate;

    /**
     * date when note was changed
     */
    private String lastChangeDate;

    public Note(String surname, String name, String middleName, String nickname,
                String comment, SubscriberGroup group, String homeNumber,
                String mobileNumber, String email, String skype, String addressIndex,
                String city, String street, String houseNumber, String apartmentNumber,
                String creationDate, String lastChangeDate) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.shortName = generateShortName();
        this.nickname = nickname;
        this.comment = comment;
        this.group = group;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.skype = skype;
        this.addressIndex = addressIndex;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.mailFormAddress = createMailFormAddress();
        this.commonFormAddress = createCommonFormAddress();
        this.creationDate = creationDate;
        this.lastChangeDate = lastChangeDate;
    }

    /**
     * method generates short subscriber name
     * form his full name
     * @return Surname N. M.
     */
    private String generateShortName() {
        char nameFirstLetter = getName().charAt(0);
        char middleNameFirstLetter = getMiddleName().charAt(0);
        return (getSurname() + " " + nameFirstLetter + ". " + middleNameFirstLetter + ".");
    }

    /**
     * method creates address that fits the mail pattern
     * @return mail form address
     */
    private String createMailFormAddress() {
        return ("St " + getStreet() + ", " + getHouseNumber() + ", Apt " + getApartmentNumber() +"\n"
                + getCity() + "\n" + getAddressIndex());
    }

    /**
     * method creates address that fits the common pattern
     * @return common form address
     */
    private String createCommonFormAddress() {
        return ("St " + getStreet() + ", " + getHouseNumber() + ", Apt " + getApartmentNumber());
    }

    public String getAddressIndex() {
        return addressIndex;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getMailFormAddress() {
        return mailFormAddress;
    }

    public String getCommonFormAddress() {
        return commonFormAddress;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getShortName() {
        return shortName;
    }

}
