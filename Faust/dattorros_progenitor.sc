FaustPlateReverb : MultiOutUGen
{
  *ar { | in1, in2, bandwidth(0.9), damping(0.0005), decay_diff_1(0.1), decay_diff_2(0.1), decay(0.1), dry_wet(0.5), excursion(0.0), input_diff_1(0.1), input_diff_2(0.1), predelay_ms(0.0) |
      ^this.multiNew('audio', in1, in2, bandwidth, damping, decay_diff_1, decay_diff_2, decay, dry_wet, excursion, input_diff_1, input_diff_2, predelay_ms)
  }

  *kr { | in1, in2, bandwidth(0.9), damping(0.0005), decay_diff_1(0.1), decay_diff_2(0.1), decay(0.1), dry_wet(0.5), excursion(0.0), input_diff_1(0.1), input_diff_2(0.1), predelay_ms(0.0) |
      ^this.multiNew('control', in1, in2, bandwidth, damping, decay_diff_1, decay_diff_2, decay, dry_wet, excursion, input_diff_1, input_diff_2, predelay_ms)
  } 

  checkInputs {
    if (rate == 'audio', {
      2.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  init { | ... theInputs |
      inputs = theInputs
      ^this.initOutputs(2, rate)
  }

  name { ^"FaustPlateReverb" }


  info { ^"Generated with Faust" }
}

