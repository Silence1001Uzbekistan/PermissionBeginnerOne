package com.example.permissionbeginnerone

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //AskPermissionOne()
        AskPermissionTwo()

    }

    private fun AskPermissionTwo() {


        Dexter.withContext(this)
            .withPermissions(
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.READ_CONTACTS,
                android.Manifest.permission.RECORD_AUDIO
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {

                    Toast.makeText(this@MainActivity, "Checked", Toast.LENGTH_SHORT).show()

                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest>,
                    token: PermissionToken
                ) {

                    Toast.makeText(
                        this@MainActivity,
                        "onPermissionRationaleShouldBeShown",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }).check()


    }

    private fun AskPermissionOne() {
        Dexter.withContext(this)
            .withPermission(android.Manifest.permission.CAMERA)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse) {

                    Toast.makeText(this@MainActivity, "Granted", Toast.LENGTH_SHORT).show()

                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) {

                    Toast.makeText(this@MainActivity, "Denied", Toast.LENGTH_SHORT).show()

                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) {

                    Toast.makeText(this@MainActivity, "RationShouldBeShown", Toast.LENGTH_SHORT)
                        .show()

                }
            }).check()
    }


}