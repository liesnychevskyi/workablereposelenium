package selenium_core;

public class XpathApproach
{
    //input[@class='input'][@name='log']
    //input[@class='input' or @name='log']
    //input[@class='input' and @name='log']
    //a[contains(@href,edit.php)][text()='Posts']
    //*[contains(@id,'edit')] for dynamic change id
    //*[starts-with(@id, 'edit')]
    //  .//*[@id='some id']//following::some attribute
    //  .//*[@id='adminmenuwrap']//following::a
    //   //label[text()='Username or Email Address']//following::input[4]
    //   //*[@id='wp-submit']//preceding::input[3]
}
