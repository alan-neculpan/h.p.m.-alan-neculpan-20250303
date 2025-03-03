package com.alan_neculpan_20250303

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

class FarmaciaListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var farmaciaAdapter: FarmaciaAdapter
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmacia_list)

        sessionManager = SessionManager(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.logoutButton).setOnClickListener {
            sessionManager.logout()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        fetchFarmacias()
    }

    private fun fetchFarmacias() {
        // Lógica para obtener datos de la API usando AsyncTask o Coroutines
        // Ejemplo usando Coroutines:
        CoroutineScope(Dispatchers.IO).launch {
            val response = URL("https://midas.minsal.cl/farmacia_v2/WS/getLocalesTurnos.php").readText()
            val farmacias = Gson().fromJson(response, Array<Farmacia>::class.java).toList()
            withContext(Dispatchers.Main) {
                farmaciaAdapter = FarmaciaAdapter(farmacias)
                recyclerView.adapter = farmaciaAdapter
            }
        }
    }
}