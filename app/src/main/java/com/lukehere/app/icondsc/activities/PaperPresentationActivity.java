package com.lukehere.app.icondsc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.fragments.TrackFragment;
import com.lukehere.app.icondsc.pojo.Paper;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class PaperPresentationActivity extends AppCompatActivity {
    public static final String PAPER_SESSION = "paper_session";
    public static final String PAPERS_ARRAY_LIST = "papers_array_list";
    private int paperSession;
    private String mTrackNamesSessionOne[] = {
            "Internet of Things",
            "Data Science",
            "Network and Information Security",
            "Software Engineering and Emerging Trends",
            "Image Processing",
            "Signal Processing",
            "Communication",
            "Embedded Systems",
            "Simulation and Modeling of Electrical Systems",
            "Smart Grids and Internet of Energy"
    };

    private String mTrackNamesSessionTwo[] = {
            "Data Science"
    };

    private ArrayList<Paper> mPapersArrayList;
    ArrayList<Paper> papersBySessionAndTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper_presentation);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.paper_presentation_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Intent intentThatStartedThisActivity = getIntent();
        paperSession = intentThatStartedThisActivity.getIntExtra(PAPER_SESSION, 1);

        setupData();
        ViewPager mPager = findViewById(R.id.pager);
        PagerAdapter mPagerAdapter = new TrackPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        TabLayout mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mPager);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private class TrackPagerAdapter extends FragmentStatePagerAdapter {

        private TrackPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            TrackFragment trackFragment = new TrackFragment();

            papersBySessionAndTrack = new ArrayList<>();
            for (int i = 0; i < mPapersArrayList.size(); i++) {
                if (mPapersArrayList.get(i).getTrackNumber() == position) {
                    papersBySessionAndTrack.add(mPapersArrayList.get(i));
                }
            }

            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(PAPERS_ARRAY_LIST, papersBySessionAndTrack);
            trackFragment.setArguments(bundle);

            return trackFragment;
        }

        @Override
        public int getCount() {
            switch (paperSession) {
                case 1:
                    return mTrackNamesSessionOne.length;
                case 2:
                    return mTrackNamesSessionTwo.length;
            }
            return 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (paperSession) {
                case 1:
                    return mTrackNamesSessionOne[position];
                case 2:
                    return mTrackNamesSessionTwo[position];
            }
            return null;
        }
    }

    private void setupData() {
        mPapersArrayList = new ArrayList<>();

        switch (paperSession) {

            //Session 1
            case 1:
                mPapersArrayList.add(new Paper(0, "Suja P Mathews", "IconDSC19_paper_33", "Protocol Recommendation for Message Encryption in MQTT", "101, 2nd Floor", "13:30-13:45"));
                mPapersArrayList.add(new Paper(0, "Sudhir K. Routray", "IconDSC19_paper_43", "Satellite Based IoT for Mission Critical Applications", "101, 2nd Floor", "13:45 - 14:00"));
                mPapersArrayList.add(new Paper(0, "Umashankar M L", "IconDSC19_paper_67", "Design Of High-Speed Reconfigurable Deployment Intelligent Genetic Algorithm In Maximum Coverage Wireless Sensor Network", "101, 2nd Floor", "14:00-14:15"));
                mPapersArrayList.add(new Paper(0, "Rahul N. Gore", "IconDSC19_paper_112", "Bluetooth based Sensor Monitoring in Industrial IoT Plants", "101, 2nd Floor", "14:15-14:30"));
                mPapersArrayList.add(new Paper(0, "Sreyan Ghosh", "IconDSC19_paper_123", "Accident Detection using Convolutional Neural Networks", "101, 2nd Floor", "14:30-14:45"));
                mPapersArrayList.add(new Paper(0, "Indu K.", "IconDSC19_paper_146", "Learning Techniques for Societal Utility Electronics - A Futuristic Survey", "101, 2nd Floor", "14:45-15:00"));
                mPapersArrayList.add(new Paper(0, "Dylan Philip Jose", "IconDSC19_paper_163", "IoT Based Water Management using HC-12 and Django", "101, 2nd Floor", "15:00-15:15"));

                mPapersArrayList.add(new Paper(1, "Induja S N", "IconDSC19_paper_3", "Computational Methods For Predicting Chronic Disease In Healthcare Communities", "102, 2nd Floor", "13:30-13:45"));
                mPapersArrayList.add(new Paper(1, "J.N.Madhuri", "IconDSC19_paper_109", "Extractive text summarization using sentences ranking", "104, 2nd Floor", "13:30-13:45"));
                mPapersArrayList.add(new Paper(1, "Shahina KK", "IconDSC19_paper_23", "A sequential labelling approach for the Named Entity Recognition in Arabic Language using deep learning algorithms", "102, 2nd Floor", "13:45-14:00"));
                mPapersArrayList.add(new Paper(1, "Iksu Yeo", "IconDSC19_paper_110", "Sentiment Analysis on Time-series Data using Weight Priority Method on Deep Learning", "104, 2nd Floor", "13:45-14:00"));
                mPapersArrayList.add(new Paper(1, "Dr. Rekha V", "IconDSC19_paper_29", "Sentiment Analysis on Indian Government Schemes Using Twitter data", "102, 2nd Floor", "14:00-14:15"));
                mPapersArrayList.add(new Paper(1, "Amrita Tamang", "IconDSC19_paper_111", "Water Demand Prediction Using Machine Learning Techniques", "104, 2nd Floor", "14:00-14:15"));
                mPapersArrayList.add(new Paper(1, "Shoieb Ahamed", "IconDSC19_paper_59", "Feature Based Fuzzy Framework for Sentimental Analysis of Web Data", "102, 2nd Floor", "14:30-14:45"));
                mPapersArrayList.add(new Paper(1, "Manohar Madgi", "IconDSC19_paper_119", "Recognition of similar colour vegetable images using machine learning", "104, 2nd Floor", "14:30-14:45"));
                mPapersArrayList.add(new Paper(1, "Prashant Lakkadwala", "IconDSC19_paper_68", "Performance Evaluation of Time Shared and Space Shared Techniques for Cloud Resource Scheduling", "102, 2nd Floor", "14:45-15:00"));
                mPapersArrayList.add(new Paper(1, "Palani Thanaraj Krishnan", "IconDSC19_paper_144", "Detection of Alphabets for Machine Translation of Sign Language using Deep Neural Net", "104, 2nd Floor", "14:45-15:00"));
                mPapersArrayList.add(new Paper(1, "Akshay Sachdeva", "IconDSC19_paper_106", "An Effective Time Series Analysis for Equity Market Prediction Using Deep Learning Model for NIFTY50", "102, 2nd Floor", "15:00-15:15"));
                mPapersArrayList.add(new Paper(1, "Anthony Suresh Aniketh", "IconDSC19_paper_164", "ChipSeq analysis with Bayesian Machine Learning", "104, 2nd Floor", "15:00-15:15"));
                mPapersArrayList.add(new Paper(1, "P. Vijaya", "IconDSC19_paper_62", "LENN: Laplacian probability based Extended Nearest Neighbor Classification Algorithm for Web Page Retrieval", "104, 2nd Floor", "15:15-15:30"));

                mPapersArrayList.add(new Paper(2, "Allu Supraja", "IconDSC19_paper_20", "Analysis On Hybrid Approach For (K, N) Secret Sharing In Visual Cryptography", "103, 2nd Floor", "13:30-13:45"));
                mPapersArrayList.add(new Paper(2, "Rajendra Hegadi", "IconDSC19_paper_26", "Performance Evaluation of In-network Caching-A Core Functionality of Information Centric Networking", "103, 2nd Floor", "13:45-14:00"));
                mPapersArrayList.add(new Paper(2, "Pragya Kuchhal", "IconDSC19_paper_143", "Energy Proficient A*Search Based Hop Selection Routing Perception in infrastructure - Less Opportunistic Networks: EA*OR", "103, 2nd Floor", "14:00-14:15"));
                mPapersArrayList.add(new Paper(2, "Kukatlapalli Pradeep Kumaar", "IconDSC19_paper_165", "Securing Provenance Data with Secret Sharing Mechanism: Model Perspective", "103, 2nd Floor", "14:15-14:30"));
                mPapersArrayList.add(new Paper(2, "Arnold Gabriel Benedict", "IconDSC19_paper_101", "Improved File Security System Using Multiple Image Steganography", "103, 2nd Floor", "14:30-14:45"));

                mPapersArrayList.add(new Paper(3, "Abhay Palaskar", "IconDSC19_paper_36", "A Practitioner’s Approach to Test WCAG 2.0 guidelines with API for easy implementation", "103, 2nd Floor", "14:45-15.00"));
                mPapersArrayList.add(new Paper(3, "S. Delphine Immaculate", "IconDSC19_paper_39", "Software Bug prediction using supervised machine learning algorithms", "103, 2nd Floor", "15.00-15.15"));

                mPapersArrayList.add(new Paper(4, "Amani Ali Ahmed Ali", "IconDSC19_paper_53", "An Efficient Character Segmentation Algorithm For Recognition of Arabic Handwritten Script", "201, 3rd Floor", "13:30-13:45"));
                mPapersArrayList.add(new Paper(4, "Arunkumar K L", "IconDSC19_paper_128", "A Novel Approach for Vehicle Distance Estimation Based On the Feature Points Using Monocular Vision", "205, 3rd Floor", "13:30-13:45"));
                mPapersArrayList.add(new Paper(4, "Sankhya N. Nayak", "IconDSC19_paper_56", "Text Localization in Natural Scene Images using SURF and MSER and SVM Classifier for Multilingual Text", "201, 3rd Floor", "13:45-14:00"));
                mPapersArrayList.add(new Paper(4, "Manjunatha HT", "IconDSC19_paper_133", "Detection and Classification of Potholes in Indian Roads using Wavelet Based Energy Modules", "205, 3rd Floor", "13:45-14:00"));
                mPapersArrayList.add(new Paper(4, "Sushma R B", "IconDSC19_paper_58", "DNA Based Steganography using 2-3-3 Technique", "201, 3rd Floor", "14:00-14:15"));
                mPapersArrayList.add(new Paper(4, "G G Rajput", "IconDSC19_paper_138", "Script Identification from Handwritten document Images Using LBP technique at Block level", "205, 3rd Floor", "14:00-14:15"));
                mPapersArrayList.add(new Paper(4, "Nikesh P.", "IconDSC19_paper_63", "Despeckling of Ultra sound Images using spatial filters – A Fusion Approach", "201, 3rd Floor", "14:15-14:30"));
                mPapersArrayList.add(new Paper(4, "Michael Moses T", "IconDSC19_paper_162", "A Deterministic Key-Frame Indexing and Selection for Surveillance Video Summarization", "205, 3rd Floor", "14:15-14:30"));
                mPapersArrayList.add(new Paper(4, "Bijeesh TV", "IconDSC19_paper_86", "A Comparative Study of Spectral Indices for Surface Water Delineation Using Landsat 8 Images", "201, 3rd Floor", "14:30-14:45"));
                mPapersArrayList.add(new Paper(4, "Sugandhi K.", "IconDSC19_paper_173", "Inter Frame Statistical feature fusion for Human Gait Recognition", "205, 3rd Floor", "14:30-14:45"));
                mPapersArrayList.add(new Paper(4, "Greeshma Katarki", "IconDSC19_paper_122", "Estimating Change Detection Of Forest Area Using Satellite Imagery", "201, 3rd Floor", "14:45-15:00"));

                mPapersArrayList.add(new Paper(5, "Resmi K R", "IconDSC19_paper_57", "A Novel Approach to Automatic Ear Detection Using Banana Wavelets and Circular Hough Transform", "202, 3rd Floor", "13:30-13:45"));
                mPapersArrayList.add(new Paper(5, "R. Venkataswamy", "IconDSC19_paper_125", "Deformation Diagnostic Methods for Transformer Winding through System Identification", "202, 3rd Floor", "13:45-14:00"));
                mPapersArrayList.add(new Paper(5, "Divyabharathi O", "IconDSC19_paper_147", "Analysis of different body parameters using Real-time HRV estimation from acquired ECG samples", "202, 3rd Floor", "14:00-14:15"));
                mPapersArrayList.add(new Paper(5, "Md. Shafiul Alam Chowdhury", "IconDSC19_paper_156", "Power spectral analysis (FFT) and Neural network (NN) for feature extraction and recognition of Bangla speech", "202, 3rd Floor", "14:15-14:30"));
                mPapersArrayList.add(new Paper(5, "Sabah Afroze", "IconDSC19_paper_160", "A Review on Fetal ECG Extraction and Measurement of Heart Rate", "202, 3rd Floor", "14:30-14:45"));

                mPapersArrayList.add(new Paper(6, "M Shailesh Kumar", "IconDSC19_paper_19", "A Study of the Effect of Dielectric Composition on Metamaterial Performance in a Multilayer Environment", "203, 3rd Floor", "13:30-13:45"));
                mPapersArrayList.add(new Paper(6, "N.Sheshaprasad", "IconDSC19_paper_65", "A study of UWB Microstrip antenna parameters for wireless applications.", "203, 3rd Floor", "13:45-14:00"));
                mPapersArrayList.add(new Paper(6, "Bharath H. P.", "IconDSC19_paper_78", "Design and Analysis of Digital Feedback loop AGC for WiMAX 802.16m Receivers", "203, 3rd Floor", "14:00-14:15"));
                mPapersArrayList.add(new Paper(6, "Delson T R", "IconDSC19_paper_91", "A Survey on 5G Standards, Specifications and Massive MIMO Testbed Including Transceiver Design Models Using QAM Modulation Schemes", "203, 3rd Floor", "14:15-14:30"));
                mPapersArrayList.add(new Paper(6, "Ashish Patil", "IconDSC19_paper_100", "Transmit Data Rate Control based Decentralized Congestion Control Mechanism for VANETs", "203, 3rd Floor", "14:30-14:45"));
                mPapersArrayList.add(new Paper(6, "Shashi Kumar D", "IconDSC19_paper_113", "Miniaturization of Microstrip Antenna with Enhanced Gain using Defected Ground Structures", "203, 3rd Floor", "14:45-15:00"));
                mPapersArrayList.add(new Paper(6, "Joseph Rodrigues", "IconDSC19_paper_124", "Narrowband and Wideband Directional Beamformer with Reduced Side Lobe Level", "203, 3rd Floor", "15:00-15:15"));

                mPapersArrayList.add(new Paper(7, "Jisha P", "IconDSC19_paper_89", "Synthesis and Electrical Characterization of Protonic Acid Doped Polyaniline for Detection of Monoterpene Vapours to Diagnose Malaria", "204, 3rd Floor", "13:30-13:45"));
                mPapersArrayList.add(new Paper(7, "Kalyana Chakaravarthy Veluvolu", "IconDSC19_paper_149", "Wearable Accelerometer based Pseudo-ECG Generation", "204, 3rd Floor", "13:45-14:00"));
                mPapersArrayList.add(new Paper(7, "Milner Paul V", "IconDSC19_paper_178", "Embedded Based Solution for Intracortical and Intracranial Microstimulations for Assessing the Behaviour of Rodents", "204, 3rd Floor", "14:00-14:15"));

                mPapersArrayList.add(new Paper(8, "Umesh V", "IconDSC19_paper_84", "Universal Electrical Motor Acoustic Noise Reduction Based on Rotor Surface Modification", "204, 3rd Floor", "14:15-14:30"));

                mPapersArrayList.add(new Paper(9, "C. Parag Jose", "IconDSC19_paper_55", "Fuzzy Based Controller for Bi Directional Power Flow Regulation for Integration of Electric Vehicles to Micro- Grid", "204, 3rd Floor", "14:30-14:45"));
                mPapersArrayList.add(new Paper(9, "Nirmala John", "IconDSC19_paper_81", "Impact of Variable Distributed Generation on Distribution System Voltage Stability", "204, 3rd Floor", "14:45-15:00"));

                break;

            //Session 2
            case 2:
                mPapersArrayList.add(new Paper(0, "S. Deepa Kanmani", "IconDSC19_paper_179", "An Effective Imputation Technique for Improving the Performance of Skyline Queries for Incomplete Database", "102, 2nd Floor", "11:00-11:15"));
                mPapersArrayList.add(new Paper(0, "Angel Caroline Johnsy", "IconDSC19_paper_181", "Revisiting the South Indian floods of 2015 with SENTINEL-1 data", "102, 2nd Floor", "11:15-11:30"));
                mPapersArrayList.add(new Paper(0, "G. G. Rajput", "IconDSC19_paper_47", "A Comparative Study of Artificial Neural Networks and Support Vector Machines for predicting stock prices in National Stock Exchange of India", "102, 2nd Floor", "11:30-11:45"));
                mPapersArrayList.add(new Paper(0, "Ramandeep Kaur", "IconDSC19_paper_116", "Multi Criteria based Handoff using FAHP and Fuzzy Inference System", "102, 2nd Floor", "11:45-12:00"));

                break;
        }
    }
}