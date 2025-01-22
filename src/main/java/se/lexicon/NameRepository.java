package se.lexicon;

import java.sql.Array;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];
    // element format should be ["firstName lastName", "firstName lastName"]

    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        return names.length;
    }

    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(final String[] names) {
        NameRepository.names = names;
    }

    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        NameRepository.names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        return names.clone();
    }

    //For testing purposes
    public static void printStringArray (String[] arr) {
        for (String element : arr) {
            System.out.println(element);
        }
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(final String fullName) {
        for (String name : names) {
            if (name.equals(fullName)) {
                return name;
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(final String fullName) {
        if (find(fullName) != null) {       //calls on find method to see if name contains
            return false;                   //fullname, if not then it returns false
        }
        String[] stringToAddTo = new String[names.length + 1];      //declares am array of Strings
        for (int i = 0; i < names.length; i++) {                    //one longer than names, then copies
            stringToAddTo[i] = names[i];                            //the values to the new string and adds
        }                                                           //the new name as the last element to the array
        stringToAddTo[stringToAddTo.length - 1] = fullName;         //then making names reflect on the new array
        names = stringToAddTo;
        return true;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(final String firstName) {
        String[] matchingNames = new String[0];
        String[] matchingNamesToReturn = new String[0];
        String[] splittedName;
        for (String name : names) {
            splittedName = name.split(" ", 2);
            if (splittedName[0].equals(firstName)) {
                matchingNames = new String[matchingNamesToReturn.length + 1];
                for (int i = 0; i < matchingNamesToReturn.length; i++) {
                    matchingNames[i] = matchingNamesToReturn[i];
                }
                matchingNames[matchingNames.length -1] = name;
            }
            matchingNamesToReturn = matchingNames;
        }
        return matchingNamesToReturn;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(final String lastName) {
        String[] matchingNames = new String[0];
        String[] matchingNamesToReturn = new String[0];
        String[] splittedName;
        for (String name : names) {
            splittedName = name.split(" ", 2);
            if (splittedName[splittedName.length - 1].equals(lastName)) {
                matchingNames = new String[matchingNamesToReturn.length + 1];
                for (int i = 0; i < matchingNamesToReturn.length; i++) {
                    matchingNames[i] = matchingNamesToReturn[i];
                }
                matchingNames[matchingNames.length -1] = name;
            }
            matchingNamesToReturn = matchingNames;
        }
        return matchingNamesToReturn;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(final String original, final String updatedName) {
        if (find(original) == null || find(updatedName) != null) {          //calls on find method to see if name contains
            return false;                                                   //fullname, if not then it returns false
        }

        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(original)) {
                names[i] = updatedName;
            }
        }
        return true;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(final String fullName) {
        if (find(fullName) == null){
            return false;
        }

        String[] arrayWithRemovedName = new String[names.length - 1];
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(fullName)){
                continue;
            }
            arrayWithRemovedName[i] = names[i];
        }
        names = arrayWithRemovedName;
        return true;
    }


}