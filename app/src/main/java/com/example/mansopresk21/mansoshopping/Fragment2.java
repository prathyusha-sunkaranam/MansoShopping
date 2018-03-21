package com.example.mansopresk21.mansoshopping;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.example.mansopresk21.mansoshopping.ExpModel.Child;
import com.example.mansopresk21.mansoshopping.ExpModel.ExpandListAdapter;
import com.example.mansopresk21.mansoshopping.ExpModel.Group;
import com.example.mansopresk21.mansoshopping.MenGrid.MenGridActivity;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;
    ImageView fragmentimage;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment



        View v1 = inflater.inflate(R.layout.fragment_fragment2, container, false);
        fragmentimage = (ImageView) v1.findViewById(R.id.fragmentmen_image);
        ExpandList = (ExpandableListView) v1.findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(getContext(), ExpListItems);
        ExpandList.setAdapter(ExpAdapter);


        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<Child> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();

                Intent i = new Intent(getActivity(), MenGridActivity.class);
                startActivity(i);



                return false;
            }
        });

        ExpandList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();


            }
        });

        ExpandList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
            }
        });
        return v1;

    }

    public ArrayList<Group> SetStandardGroups() {

        ArrayList<Group> group_list = new ArrayList<Group>();
        ArrayList<Child> child_list;

        // Setting Group 1

        // Setting Group 2
        child_list = new ArrayList<Child>();
        Group gru2 = new Group();
        gru2.setName("Men");

        Child ch2_1 = new Child();
        ch2_1.setName("Casual Shirts");
        child_list.add(ch2_1);

        Child ch2_2 = new Child();
        ch2_2.setName("Polos & Tees");
        child_list.add(ch2_2);

        Child ch2_3 = new Child();
        ch2_3.setName("Formal Shirts");
        child_list.add(ch2_3);

        Child ch2_4 = new Child();
        ch2_4.setName("Ethnic wear");
        child_list.add(ch2_4);

        Child ch2_5 = new Child();
        ch2_5.setName("Winter wear");
        child_list.add(ch2_5);

        Child ch2_6 = new Child();
        ch2_6.setName("Denims");
        child_list.add(ch2_6);

        Child ch2_7 = new Child();
        ch2_7.setName("Formal Trousers");
        child_list.add(ch2_7);


        gru2.setItems(child_list);


        child_list = new ArrayList<Child>();
        Group gru3 = new Group();
        gru3.setName("Footwear");

        Child ch3_1 = new Child();
        ch3_1.setName("Casual Shoes");
        child_list.add(ch3_1);

        Child ch3_2 = new Child();
        ch3_2.setName("Formal Shoes");
        child_list.add(ch3_2);

        Child ch3_3 = new Child();
        ch3_3.setName("Sports Shoes");
        child_list.add(ch3_3);

        Child ch3_4 = new Child();
        ch3_4.setName("Sneakers");
        child_list.add(ch3_4);

        Child ch4_5 = new Child();
        ch4_5.setName("Boots");
        child_list.add(ch4_5);

        Child ch5_5 = new Child();
        ch5_5.setName("Slippers");
        child_list.add(ch5_5);

        Child ch6_5 = new Child();
        ch6_5.setName("Flip Flops");
        child_list.add(ch6_5);

        Child ch7_5 = new Child();
        ch7_5.setName("Sandals");
        child_list.add(ch7_5);



        gru3.setItems(child_list);




        //listing all groups

        group_list.add(gru2);
        group_list.add(gru3);


        return group_list;

    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
