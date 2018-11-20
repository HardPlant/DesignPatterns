public class PersonBeanImpl implements PersonBean{
    String name;
    String gender;
    String interests;
    int rating;
    int ratingCount = 0;
    @Override
    public String getName() {
        return name;
    }
    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * @return the interests
     */
    public String getInterests() {
        return interests;
    }
    @Override
    public int getHotOrNotRating() {
        if(ratingCount == 0) return 0;
        return (rating/ratingCount);
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * @param interests the interests to set
     */
    public void setInterests(String interests) {
        this.interests = interests;
    }
    @Override
    public void setHotOrNotRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }
}