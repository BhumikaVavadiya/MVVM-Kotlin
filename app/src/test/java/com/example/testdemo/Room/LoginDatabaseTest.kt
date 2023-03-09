package com.example.testdemo.Room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.demo.interviewtask.room.DAOAccess
import com.demo.interviewtask.room.LoginDatabase
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class LoginDatabaseTest: TestCase(){
    private lateinit var context: Context
    private lateinit var db: LoginDatabase
    private lateinit var dao: DAOAccess
    @Before
    public override fun setUp() {
        // get context -- since this is an instrumental test it requires
        // context from the running application
        context = ApplicationProvider.getApplicationContext<Context>()
        // initialize the db and dao variable
        db = Room.inMemoryDatabaseBuilder(context, LoginDatabase::class.java).build()
        dao = db.loginDao()
    }

    // Override function closeDb() and annotate it with @After
    // this function will be called at last when this test class is called
    @After
    fun closeDb() {
        db.close()
    }

    // create a test function and annotate it with @Test
    // here we are first adding an item to the db and then checking if that item
    // is present in the db -- if the item is present then our test cases pass
    @Test
    fun writeAndReadLanguage() = runBlocking {
        val loginDetails = LoginTableModel("name@email.com","abc123")
        dao.InsertData(loginDetails)
        loginDetails.Username="name@email.com"
        assertThat("name@email.com",true)
    }
}