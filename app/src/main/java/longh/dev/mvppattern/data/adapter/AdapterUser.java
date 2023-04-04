package longh.dev.mvppattern.data.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import longh.dev.mvppattern.Constract;
import longh.dev.mvppattern.ListConstract;
import longh.dev.mvppattern.R;
import longh.dev.mvppattern.data.model.User;
import longh.dev.mvppattern.persenter.PresenterList;

public class AdapterUser extends BaseAdapter {
    Context context;
    List<User> mListUser;
    ListConstract.IPresenter iPresenter;

    public AdapterUser(Context context, List<User> mListUser) {
        this.context = context;
        this.mListUser = mListUser;
        iPresenter = new PresenterList((ListConstract.IView) context);
    }

    @Override
    public int getCount() {
        return mListUser.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.row_listuser,null);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView txtID = row.findViewById(R.id.textviewID);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView txtUser = row.findViewById(R.id.textview1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView txtPass = row.findViewById(R.id.textview2);
//        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView btnUpdate = row.findViewById(R.id.btn_edit);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView btnDelete = row.findViewById(R.id.btn_delete);
        User user = mListUser.get(i);
        txtID.setText(user.getId()+"");
        txtUser.setText(user.getEmail());
        txtPass.setText(user.getPassword());
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogXoa =  new AlertDialog.Builder(context);
                dialogXoa.setMessage("Bạn có muốn xoá không ?");
                dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        iPresenter.delete(user.getId());
//                        mListUser.remove(i);
                        mListUser.remove(i);
                        notifyDataSetChanged();
                    }
                });
                dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialogXoa.create().show();
            }
        });
        
        return row;
    }

}
