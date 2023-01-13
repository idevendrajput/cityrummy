package com.gamegards.cityrummy.Comman;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gamegards.cityrummy.Interface.ApiRequest;
import com.gamegards.cityrummy.Interface.Callback;
import com.gamegards.cityrummy.R;
import com.gamegards.cityrummy.SampleClasses.Const;
import com.gamegards.cityrummy.Utils.Functions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DialogForgetPassword {

    Context context;
    public DialogForgetPassword(Context context) {
        this.context = context;
    }

    public interface DealerInterface{

        void onClick(int pos);

    }

    public void showReportDialog() {
        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_forget_password);
        dialog.setTitle("Title...");

        TextView tv_heading = dialog.findViewById(R.id.tv_heading);

        tv_heading.setText("Forget Password!");

        final EditText edtForgetMobile = (EditText) dialog.findViewById(R.id.edtForgetMobile);

        dialog.findViewById(R.id.btn_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!Functions.checkisStringValid(Functions.getStringFromEdit(edtForgetMobile)))
                {
                    Functions.showToast(context,"Please enter Mobile Number.");
                    return;
                }
                else if (Functions.getStringFromEdit(edtForgetMobile).length() < 10)
                {
                    Functions.showToast(context,"Please Valid Mobile Number.");
                    return;
                }

                CALL_API_ForgetPassword(Functions.getStringFromEdit(edtForgetMobile));


                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.bt_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.ivClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void CALL_API_ForgetPassword(String mobile){

        HashMap params = new HashMap();
        params.put("mobile",""+mobile);

        ApiRequest.Call_Api(context, Const.forgetpassword, params, new Callback() {
            @Override
            public void Responce(String resp, String type, Bundle bundle) {

                if(resp != null)
                {

                    try {
                        JSONObject jsonObject = new JSONObject(resp);
                        String code = jsonObject.optString("code");
                        String message = jsonObject.optString("message");

                        if(code.equals("200"))
                        {
                        }
                        Functions.showToast(context,""+message);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

    }


}
