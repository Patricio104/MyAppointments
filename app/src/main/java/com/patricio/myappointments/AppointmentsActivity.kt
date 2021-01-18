package com.patricio.myappointments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.patricio.myappointments.model.Appointment
import kotlinx.android.synthetic.main.activity_appointments.*

class AppointmentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        val appointments = ArrayList<Appointment>()
        appointments.add(
            Appointment(1, "Medico 1", "12/01/2021", "3:00 PM" )
        )
        appointments.add(
            Appointment(2, "Medico 2", "12/01/2021", "3:30 PM" )
        )
        appointments.add(
            Appointment(3, "Medico 3", "12/01/2021", "4:00 PM" )
        )

        rvAppointments.layoutManager = LinearLayoutManager(this)
        rvAppointments.adapter = AppointmentAdapter(appointments)
    }
}
