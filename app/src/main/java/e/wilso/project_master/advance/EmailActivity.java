package e.wilso.project_master.advance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import e.wilso.project_master.R;

public class EmailActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

   EditText etTo, etSub, etMsg;
   Button btSend, btnClear;
   String to, subject, message;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_email);

      findView();
      getSupportActionBar().setTitle("Feedback");
      setBackbutton();

      btSend.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            //to = etTo.getText().toString();
            to = "wilson155079@gmail.com";
            subject = etSub.getText().toString();
            message = etMsg.getText().toString();

            if(subject.isEmpty()){
               Toast.makeText(EmailActivity.this, "You must enter a Subject", Toast.LENGTH_LONG).show();
            }
            else if(message.isEmpty()) {
               Toast.makeText(EmailActivity.this, "You must enter a message", Toast.LENGTH_LONG).show();
            }
            else {
               Intent email = new Intent(Intent.ACTION_SEND);
               email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
               email.putExtra(Intent.EXTRA_SUBJECT, subject);
               email.putExtra(Intent.EXTRA_TEXT, message);

               //need this to prompts email client only
               email.setType("message/rfc822");
               startActivity(Intent.createChooser(email, "Choose Email client :"));
            }
         }
      });

      btnClear.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            //etTo.setText(null);
            etSub.setText(null);
            etMsg.setText(null);
         }
      });
   }

   /*@Override
   public void onClick(View v) {
      int i = v.getId();

      if(i == btSend.getId()) {
         Toast.makeText(EmailActivity.this, "i == btSend.getId()", Toast.LENGTH_LONG).show();
         to = etTo.getText().toString();
         subject = etSub.getText().toString();
         message = etMsg.getText().toString();

         if(to.isEmpty()){
            Toast.makeText(EmailActivity.this, "You must enter a recipient email", Toast.LENGTH_LONG).show();
         }
         else if(subject.isEmpty()){
            Toast.makeText(EmailActivity.this, "You must enter a Subject", Toast.LENGTH_LONG).show();
         }
         else if(message.isEmpty()) {
            Toast.makeText(EmailActivity.this, "You must enter a message", Toast.LENGTH_LONG).show();
         }
         else {
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
            email.putExtra(Intent.EXTRA_SUBJECT, subject);
            email.putExtra(Intent.EXTRA_TEXT, message);

            //need this to prompts email client only
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email, "Choose Email client :"));
         }
      }

      else if(i == btnClear.getId()) {
         Toast.makeText(EmailActivity.this, "i == btnClear.getId()", Toast.LENGTH_LONG).show();
         /*etTo.setText(null);
         etSub.setText(null);
         etMsg.setText(null);
      }
   }*/

   private void findView() {
      //etTo = findViewById(R.id.toEmailEditText);
      etSub = findViewById(R.id.subjectEditText);
      etMsg = findViewById(R.id.messageEditText);
      btSend = findViewById(R.id.sendMessageButton);
      btnClear = findViewById(R.id.clearButton);
   }

   private void setBackbutton() {
      if(getSupportActionBar() != null) {
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setDisplayShowHomeEnabled(true);
      }
   }

   @Override
   public void onBackPressed() {
      int count = getFragmentManager().getBackStackEntryCount();

      if(count == 0) super.onBackPressed();
      else getFragmentManager().popBackStack();
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      if(item.getItemId() == android.R.id.home) finish();

      return super.onOptionsItemSelected(item);
   }
}
