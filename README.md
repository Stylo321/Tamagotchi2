IMAD ASSIGNMENT 2 ESSEY
This essay will be elaborating on how I came about creating my game for my assignment with all the challenges I came across and how I solved them included the utilization of GitHub and GitHub actions. It will be more in depth on the source code used .
Firstly after reading and thoroughly going through the assignment instructions and illustration of the game we are supposed to create I noticed that the user interface is built up of mostly TextViews therefore knew that the user interface would be the easiest part of the whole project. The logic of the code is what I needed to figure out so after countless hours of research I figured out and understood  how I am supposed to go about creating and structuring my code. First I needed to add a class on top of the existing  “MainActivity2” class where I’ll add the mathematical logic behind the app. The newly added class is called “class Tamagotchi” and under it is 3 variables namely Hunger, Happiness& Cleanliness…this is what it looks like :

class Tamagotchi {
    var hunger = 0
    var happiness = 100
    var cleanliness = 100
  the numbers next to the names are the default numbers before the countdown/timer starts.
One example of the actions that the game does and how I coded it is that after a few seconds of the feed button being untouched the creature will starve so that means the hunger levels will rise from 0 in intervals of 10 until it reaches starvation which is 100 and this is the code for it:
fun starve() {
    hunger = (hunger + 10).coerceAtMost(100)
}
 as shown in the code above the code for this specific game is Mathematical and is quite simple.
Once you start feeding the creature the numbers should decrease(until it reaches 0)  because it means that it is being fed and the hunger is decreasing, it decreases in intervals of 10 and this is the code for it:
fun feed() {
    hunger = (hunger - 10).coerceAtLeast(0)
}

Onto the class “MainActivity2” this is where we Initialize the TextView elements which is basically declaring them like so “hungerTextView = findViewById(R.id.hungerTextView)” and also where I initialized the Tamagotchi class into tamagotchi “tamagotchi = Tamagotchi()”, after that the Button Click Listeners must be setup(commanding the buttons) and this part/section of my code was very important because under on Click Listener I added a Toast and Intent to link activities like so:
val feedButton: Button = findViewById(R.id.feedButton)
feedButton.setOnClickListener {
    tamagotchi.feed()
    updateUI()
    val intent = Intent(this, MainActivity7 ::class.java)
    startActivity(intent)
    Toast.makeText(this,"I am Eating",Toast.LENGTH_LONG).show()
}
this is and example of the feedbuttons onClickListener If you click the feed button it should transfer you into the next page which is “MainActivity7”and that is what the Intent is for, its to teleport through activities by the press of a button.

The next part of code should be the instructions to decrease and increase the levels of hunger 
INCREASE HUNGER CODE:
handler.postDelayed(object : Runnable {
    override fun run() {
        tamagotchi.starve()
        updateUI ()
        handler.postDelayed(this, 10000) // Delay every 10 seconds
    }
}, 10000) 
I have inserted comments on my code to show my own understanding at the same time to make the code simpler to understand for myself and someone else to understand. That is basicially the code for “MainActivity2”

The tricky part was when I was looking to insert a more engaging user-interface and exceed the minimum requirements and  tried to insert a moving image view (Gif) it didn’t work but as I tried to do more research on how to insert Gifs to android studio projects  I came across a youtube video that basically said I needed to add an implementation in the build.gradle under dependencies and after that I have to try put the <GifTextView/> in activity_main2. It didn’t work because I have the updated version AndroidStudioIguana and the sources android studio was “AndroidStudio Hedgehog” so the way and format of the code under dependencies is written was very different from the one I had so I had to do trial and error until I  figured out the perfect way to to code in the implementation.
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("pl.droidsonroids.gif:android-gif-drawable:1.2.19")
the last line of code is the Implementation imported from the older predecessor of android Studio Iguana and as you can see it is different in the way it was written, after I had written this line of code I  had to go sync the build.gradle.kts and rebuild the project which is crucial for it to work. Now you can insert the <GifTextView/> as <pl.droidsonroids.gif.GifImageView/> it wont show any errors and you can now import your Gif image and it should function the way its designed too.

The android manifest file I didn’t do much but all I did was insert a user permission to use the Internet :
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
From this point of the Project I had to design all of the activities using Gifs, Websites and link them to correct buttons using intents and toasts here and there.
The images below are the user interfaces:
 ![Screenshot (17)](https://github.com/Stylo321/Tamagotchi/assets/165194260/63f3c123-5357-43a8-b9e4-1d8535ed839a)

Welcome page.
 ![Screenshot (22)](https://github.com/Stylo321/Tamagotchi/assets/165194260/205a5742-efe5-4212-88e8-c8c514b3cc79)

Monitor/Main screen.
![Screenshot (19)](https://github.com/Stylo321/Tamagotchi/assets/165194260/0409d979-e87a-46bb-a3eb-de27f31173fe)

 UI if Feed  button is pressed.
 ![Screenshot (20)](https://github.com/Stylo321/Tamagotchi/assets/165194260/f27da507-74a6-4641-9f45-3d987876a665)

 UI If bath button is pressed.
 	![Screenshot (23)](https://github.com/Stylo321/Tamagotchi/assets/165194260/4c8bccb0-bc20-4b11-9216-e3e5b9039bef)

UI If play button is pressed.	


GITHUB/GITHUB ACTIONS
I first had to create a GitHub account and also a repository where I store all my code and other Gradle files, firstly in android studio you Push your project to GitHub. Once all my files are in GitHub I can now merge my projects and look into pull requests from other developers who are interested or spotted mistakes in my project. To double check if my game would run on other devices and not just my own I used Github actions and another code editor verified by Microsoft(VS CODE) to run tests and a Gradle file to check for bugs and problems…when the results came in there were reportidly “no problems in the workspace”


 Youtube video link: https://youtu.be/eKbPmuka6Vs?si=SDABMvhwmw4ICjmX
REFERENCE LIST
1.	Understanding GitHub Actions  Automated Testing – Dev Leonard.2023.YouTube video, added by Dev Leonardo.[Online].Available at:
https://www.youtube.com/watch?v=WW6ZUw9IExA&t=126s&pp=ygUXZ2l0aHViIGFjdGlvbnMgdHV0b3JpYWw%3D  [Accessed 04 May 2024]

2.	add sound or music in android app kotlin android studio tutorial  - Usman Software Engineer.2023.Youtube Video, added by Usman Software Engineer.[Online].Available at: https://youtu.be/XcXPIaqX-Qw?si=pHiUr2w7c2QRvfDY [Accessed 1 May 2024]

3.	How to Add Gif Image In Android | Android Studio Tutorial-TechizVibe.20/21.Youtube video,added by TechizVibe.[Online] Available at: https://youtu.be/KsyCfxxEIwQ?si=HtyenYm3KvS1J2Xy [Accessed 20 April 2024]

4.	How to create a Splash Screen in Android Studio (Kotlin 2020)-Indently.2020.Youtube Video,added by Indently.[Online].Available at: https://www.youtube.com/watch?v=WZWr0Abomfw [Accessed 14 April 2024]

5.	(Tamagotchi Game Mini Clone)-MJ Codes.2021.Youtube,added by MJ Codes.[Online].Available at: https://youtu.be/7m6O9zqZFZ8 [Accessed 2 April 2024]

